import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        if (filename.endsWith(".fs")) {
            // Load from compiled binary file
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                FSM loadedFSM = (FSM) ois.readObject();
                fsm.symbols = loadedFSM.symbols;
                fsm.states = loadedFSM.states;
                fsm.initialState = loadedFSM.initialState;
                fsm.finalStates = loadedFSM.finalStates;
                fsm.transitions = loadedFSM.transitions;
                System.out.println("FSM loaded from binary file: " + filename);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading FSM: " + e.getMessage());
            }
        } else {
            // Load from plain text file
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

                String firstLine = reader.readLine();
                if (firstLine == null) {
                    System.out.println("Warning: File is empty. Load aborted.");
                    return;
                }

                boolean isPlainText = true;
                for (char c : firstLine.toCharArray()) {
                    if ((int) c < 32 && c != '\n' && c != '\r' && c != '\t') {
                        isPlainText = false;
                        break;
                    }
                }

                if (!isPlainText) {
                    System.out.println("Warning: File does not appear to be plain text. Load aborted.");
                    return;
                }

                int lineNumber = 1;
                Scanner scanner = new Scanner(reader);
                do {
                    String line = (lineNumber == 1) ? firstLine.trim() : scanner.nextLine().trim();

                    // ? başındaysa temizle
                    if (line.startsWith("?")) {
                        line = line.substring(1).trim();
                    }

                    // ; sonrası yorumsa temizle
                    int semicolon = line.indexOf(';');
                    if (semicolon != -1) {
                        line = line.substring(0, semicolon).trim();
                    }

                    // Boşsa geç
                    if (line.isEmpty()) continue;

                    try {
                        executeLine(line, fsm);
                    } catch (Exception ex) {
                        System.out.println("Error on line " + lineNumber + ": " + ex.getMessage());
                    }

                    lineNumber++;
                } while (scanner.hasNextLine());

                scanner.close();
                System.out.println("Text file processed: " + filename);

            } catch (IOException e) {
                System.out.println("Error reading text file: " + e.getMessage());
            }
        }
    }

    private void executeLine(String line, FSM fsm) {
        int firstSpace = line.indexOf(" ");
        String command = (firstSpace == -1) ? line : line.substring(0, firstSpace);
        String[] args = (firstSpace == -1) ? new String[0] : line.substring(firstSpace + 1).split(" ");

        switch (command.toUpperCase()) {
            case "CLEAR":
                fsm.clear();
                break;
            case "PRINT":
                if (args.length > 0) {
                    print.handlePrint(args);
                } else {
                    System.out.println(fsm.toString());
                }
                break;
            case "SYMBOLS":
                fsm.symbols.clear();
                for (String symbol : args) {
                    fsm.symbols.add(symbol);
                }
                break;
            case "STATES":
                fsm.states.clear();
                for (String state : args) {
                    fsm.states.add(state);
                }
                break;
            case "INITIAL-STATE":
                if (args.length > 0) {
                    fsm.initialState = args[0];
                }
                break;
            case "FINAL-STATES":
                fsm.finalStates.clear();
                for (String state : args) {
                    fsm.finalStates.add(state);
                }
                break;
            case "TRANSITIONS":
                fsm.transitions.clear();
                for (String arg : args) {
                    String[] parts = arg.split(",");
                    for (String part : parts) {
                        String[] items = part.trim().split("\\s+");
                        if (items.length == 3) {
                            String symbol = items[0];
                            String from = items[1];
                            String to = items[2];
                            fsm.transitions.putIfAbsent(symbol, new HashMap<>());
                            fsm.transitions.get(symbol).put(from, to);
                        }
                    }
                }
                break;
            case "COMPILE":
                if (args.length > 0) {
                    compile.handleCompile(args[0]);
                } else {
                    System.out.println("Missing filename for COMPILE.");
                }
                break;
            case "LOAD":
                if (args.length > 0) {
                    Load nestedLoader = new Load(fsm);
                    nestedLoader.handleLoad(args[0]);
                } else {
                    System.out.println("Missing filename for LOAD.");
                }
                break;
            case "EXIT":
                System.out.println("EXIT command detected in file. Stopping execution.");
                System.exit(0);
                break;
            default:
                System.out.println("Unknown command: " + command);
        }
    }
}

