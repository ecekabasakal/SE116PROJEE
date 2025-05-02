import java.util.*;

public class StatesManager {
    private States states;

    public StatesManager() {
        states = new States();
    }

    private boolean isAlphanumeric(String s) {
        return s.matches("[a-zA-Z0-9]+");
    }

    public void processCommand(String commandLine) {
        String[] tokens = commandLine.trim().split("\\s+");
        if (tokens.length == 0) return;

        String command = tokens[0].toUpperCase();

        switch (command) {
            case "STATES":
                if (tokens.length == 1) {
                    // No arguments: print current state info
                    states.printStates();
                } else {
                    for (int i = 1; i < tokens.length; i++) {
                        String state = tokens[i];
                        if (isAlphanumeric(state)) {
                            states.addState(state);
                        } else {
                            System.out.println("Warning: State \"" + state + "\" is not alphanumeric and will be ignored.");
                        }
                    }
                }
                break;

            case "INITIAL-STATE":
                if (tokens.length < 2) {
                    System.out.println("Warning: INITIAL-STATE command requires a state name.");
                } else {
                    String initialState = tokens[1];
                    if (isAlphanumeric(initialState)) {
                        states.setInitialState(initialState);
                    } else {
                        System.out.println("Warning: Initial state \"" + initialState + "\" is not alphanumeric.");
                    }
                }
                break;

            case "FINAL-STATES":
                if (tokens.length < 2) {
                    System.out.println("Warning: FINAL-STATES command requires at least one state.");
                } else {
                    for (int i = 1; i < tokens.length; i++) {
                        String finalState = tokens[i];
                        if (isAlphanumeric(finalState)) {
                            states.addFinalState(finalState);
                        } else {
                            System.out.println("Warning: Final state \"" + finalState + "\" is not alphanumeric and will be ignored.");
                        }
                    }
                }
                break;

            default:
                System.out.println("Warning: Unknown command \"" + command + "\".");
        }
    }

    public States getStates() {
        return states;
    }
}
