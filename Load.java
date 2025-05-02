import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

public class Load {
    private FSM fsm;
    private Print print;
    private Compile compile;

    public Load(FSM fsm) {
        this.fsm = fsm;
        this.print = new Print(fsm);
        this.compile = new Compile(fsm);
    }

    public void handleLoad(String filename) {
        try {

            if (filename == null || filename.trim().isEmpty()) {
                throw new LoadFileFormatException("Filename cannot be null or empty");
            }
            if (!isValidFilename(filename)) {
                throw new LoadFileFormatException("Invalid filename format: " + filename);
            }

            if (filename.endsWith(".fs")) {

                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                    FSM loadedFSM = (FSM) ois.readObject();

                    if (loadedFSM == null) {
                        throw new LoadFileFormatException("Invalid FSM data in binary file: " + filename);
                    }

                    fsm.symbols = loadedFSM.symbols;
                    fsm.states = loadedFSM.states;
                    fsm.initialState = loadedFSM.initialState;
                    fsm.finalStates = loadedFSM.finalStates;
                    fsm.transitions = loadedFSM.transitions;
                    System.out.println("FSM loaded from binary file: " + filename);
                } catch (FileNotFoundException e) {
                    throw new LoadFileNotFoundException("File not found: " + filename);
                } catch (IOException | ClassNotFoundException | ClassCastException e) {
                    throw new LoadFileFormatException("Invalid or corrupted binary file: " + filename + " - " + e.getMessage());
                }
            } else {

                try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                    String firstLine = reader.readLine();
                    if (firstLine == null) {
                        throw new LoadFileFormatException("File is empty: " + filename);
                    }


                    if (!isPlainText(firstLine)) {
                        throw new LoadFileFormatException("File is not plain text: " + filename);
                    }

                    int lineNumber = 1;
                    String line = firstLine.trim();
                    do {

                        if (line.startsWith("?")) {
                            line = line.substring(1).trim();
                        }

                        int semicolon = line.indexOf(';');
                        if (semicolon != -1) {
                            line = line.substring(0, semicolon).trim();
                        }

                        if (!line.isEmpty()) {
                            try {
                                fsm.logCommand(line); // Log the command
                                executeLine(line, fsm);
                            } catch (Exception e) {

                                throw new LoadCommandExecution("Error on line " + lineNumber + ": " + e.getMessage());
                            }
                        }

                        lineNumber++;
                        line = reader.readLine();
                        if (line != null) {
                            line = line.trim();
                        }
                    } while (line != null);

                    System.out.println("Text file processed: " + filename);
                } catch (FileNotFoundException e) {
                    throw new LoadFileNotFoundException("File not found: " + filename);
                } catch (IOException e) {
                    throw new LoadFileFormatException("Error reading text file: " + filename + " - " + e.getMessage());
                }
            }
        } catch (LoadFileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (LoadFileFormatException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (LoadCommandExecution e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {

            System.err.println("Unexpected error while loading file: " + e.getMessage());
        }
    }

    private void executeLine(String line, FSM fsm) throws Exception {
        int firstSpace = line.indexOf(" ");
        String command = (firstSpace == -1) ? line : line.substring(0, firstSpace);
        String[] args = (firstSpace == -1) ? new String[0] : line.substring(firstSpace + 1).split("\\s+");

        switch (command.toUpperCase()) {
            case "CLEAR":
                fsm.clear();
                break;
            case "PRINT":
                print.handlePrint(args);
                break;
            case "SYMBOLS":
                for (String symbol : args) {
                    if (!symbol.matches("[a-zA-Z0-9]")) {
                        throw new NonAlphanumericSymbolException("Symbol must be alphanumeric: " + symbol);
                    }
                    if (fsm.symbols.contains(symbol)) {
                        throw new DuplicateSymbolWarningException("Symbol already declared: " + symbol);
                    }
                    fsm.symbols.add(symbol);
                }
                if (args.length == 0 && fsm.symbols.isEmpty()) {
                    throw new EmptySymbolListException("Symbol list is empty");
                }
                break;
            case "STATES":
                for (String state : args) {
                    if (!state.matches("[a-zA-Z0-9]+")) {
                        throw new NonAlphanumericStateException("State must be alphanumeric: " + state);
                    }
                    if (fsm.states.contains(state)) {
                        throw new DuplicateStateWarningException("State already declared: " + state);
                    }
                    fsm.states.add(state);
                }
                if (args.length == 0 && fsm.states.isEmpty()) {
                    throw new EmptyStateListException("State list is empty");
                }
                break;
            case "INITIAL-STATE":
                if (args.length == 0 || args[0].isEmpty()) {
                    throw new InvalidInitialStateException("Initial state cannot be empty");
                }
                if (!args[0].matches("[a-zA-Z0-9]+")) {
                    throw new InvalidInitialStateException("Initial state must be alphanumeric: " + args[0]);
                }
                if (!fsm.states.contains(args[0])) {
                    throw new UndeclaredInitialStateWarningException("Initial state not previously declared: " + args[0]);
                }
                fsm.initialState = args[0];
                break;
            case "FINAL-STATES":
                for (String state : args) {
                    if (!state.matches("[a-zA-Z0-9]+")) {
                        throw new InvalidFinalStateException("Final state must be alphanumeric: " + state);
                    }
                    if (!fsm.states.contains(state)) {
                        throw new UndeclaredFinalStateWarningException("Final state not previously declared: " + state);
                    }
                    if (fsm.finalStates.contains(state)) {
                        throw new DuplicateFinalStateWarningException("Final state already declared: " + state);
                    }
                    fsm.finalStates.add(state);
                }
                break;
            case "TRANSITIONS":
                StringBuilder fullTransitionCommand = new StringBuilder("TRANSITIONS ");
                for (String arg : args) {
                    fullTransitionCommand.append(arg).append(" ");
                }
                TransitionManager transitionManager = new TransitionManager(fsm.symbols, fsm.states);
                transitionManager.processTransitionsCommand(fullTransitionCommand.toString().trim());

                fsm.transitions.clear();
                for (String fromState : transitionManager.transitionTable.keySet()) {
                    Map<String, Transition> innerMap = transitionManager.transitionTable.get(fromState);
                    for (String symbol : innerMap.keySet()) {
                        fsm.transitions.putIfAbsent(symbol, new HashMap<>());
                        fsm.transitions.get(symbol).put(fromState, innerMap.get(symbol).getNextState());
                    }
                }
                break;
            case "COMPILE":
                if (args.length == 0) {
                    throw new InvalidCompileFilenameException("Missing filename for COMPILE");
                }
                compile.handleCompile(args[0]);
                break;
            case "LOAD":
                if (args.length == 0) {
                    throw new LoadFileFormatException("Missing filename for LOAD");
                }
                Load nestedLoader = new Load(fsm);
                nestedLoader.handleLoad(args[0]);
                break;
            case "LOG":
                fsm.handleLogCommand(line);
                break;
            case "EXIT":
                System.out.println("EXIT command detected in file. Stopping execution.");
                System.exit(0);
                break;
            default:
                throw new InvalidCommandSyntaxException("Unknown command: " + command);
        }
    }


    private boolean isValidFilename(String filename) {
        return filename.matches("[a-zA-Z0-9.-][a-zA-Z0-9.-]*");
    }

    private boolean isPlainText(String line) {
        for (char c : line.toCharArray()) {
            if ((int) c < 32 && c != '\n' && c != '\r' && c != '\t') {
                return false;
            }
        }
        return true;
    }
}