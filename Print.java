import java.io.*;

public class Print {
    private FSM fsm;

    public Print(FSM fsm) {
        this.fsm = fsm;
    }

    public void handlePrint(String... args) {
            if (args.length == 0) {
            System.out.println(fsm.toString());
            return;
        }

                String filename = args[0];
        try {
            
            if (filename == null || filename.trim().isEmpty()) {
                throw new InvalidPrintFilenameException("Filename cannot be null or empty");
            }
            if (!isValidFilename(filename)) {
                throw new InvalidPrintFilenameException("Invalid filename format: " + filename);
            }

                  try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
                    writer.print("SYMBOLS ");
                for (String symbol : fsm.symbols) {
                    writer.print(symbol + " ");
                }
                writer.println(";");

                writer.print("STATES ");
                for (String state : fsm.states) {
                    writer.print(state + " ");
                }
                writer.println(";");

                writer.println("INITIAL-STATE " + (fsm.initialState != null ? fsm.initialState : "undefined") + ";");

                
                writer.print("FINAL-STATES ");
                for (String finalState : fsm.finalStates) {
                    writer.print(finalState + " ");
                }
                writer.println(";");


                writer.print("TRANSITIONS ");
                boolean first = true;
                for (var symbol : fsm.transitions.keySet()) {
                    for (var fromState : fsm.transitions.get(symbol).keySet()) {
                        var toState = fsm.transitions.get(symbol).get(fromState);
                        if (!first) {
                            writer.print(", ");
                        }
                        writer.print(symbol + " " + fromState + " " + toState);
                        first = false;
                    }
                }
                writer.println(";");


                writer.flush();
                System.out.println("FSM written to file: " + filename);
            } catch (FileNotFoundException e) {

                throw new PrintFileCreationException("Cannot create file: " + filename + " - " + e.getMessage());
            } catch (IOException e) {
                throw new PrintFileWriteException("Error writing to file: " + filename + " - " + e.getMessage());
            }
        } catch (InvalidPrintFilenameException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (PrintFileCreationException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (PrintFileWriteException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error while printing to file: " + e.getMessage());
        }
    }

        private boolean isValidFilename(String filename) {
                return filename.matches("[a-zA-Z0-9.-][a-zA-Z0-9.-]*");
        }
    }