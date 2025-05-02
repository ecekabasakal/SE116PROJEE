import java.io.Serializable;
import java.util.*;

public class FSM implements Serializable {
    private static final long serialVersionUID = 1L;

    private LogManager logManager = new LogManager();
    public Set<String> symbols = new LinkedHashSet<>();
    public Set<String> states = new LinkedHashSet<>();
    public String initialState;
    public Set<String> finalStates = new LinkedHashSet<>();
    public Map<String, Map<String, String>> transitions = new HashMap<>();

    public void handleLogCommand(String command) {
        try {
            if (command == null || command.trim().isEmpty()) {
                throw new InvalidCommandSyntaxException("Log command cannot be null or empty");
            }
            logManager.handleLogCommand(command);
        } catch (LogFileCreationException e) {
            System.err.println("Error: Cannot create log file - " + e.getMessage());
        } catch (LogFileWriteException e) {
            System.err.println("Error: Cannot write to log file - " + e.getMessage());
        } catch (LogAlreadyActiveException e) {
            System.err.println("Error: Logging already active - " + e.getMessage());
        } catch (InvalidCommandSyntaxException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error in log command: " + e.getMessage());
        }
    }

    public void logCommand(String command) {
        try {
            if (command == null || command.trim().isEmpty()) {
                throw new InvalidCommandSyntaxException("Command to log cannot be null or empty");
            }
            logManager.logCommand(command);
        } catch (LogFileWriteException e) {
            System.err.println("Error: Cannot write command to log file - " + e.getMessage());
        } catch (InvalidCommandSyntaxException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error logging command: " + e.getMessage());
        }
    }

    public void clear() {
        try {
            symbols.clear();
            states.clear();
            initialState = null;
            finalStates.clear();
            transitions.clear();
        } catch (UnsupportedOperationException e) {
            throw new ClearOperationFailureException("Failed to clear FSM data: " + e.getMessage());
        } catch (Exception e) {
            throw new ClearOperationFailureException("Unexpected error during clear operation: " + e.getMessage());
        }
    }

    public Set<String> getSymbols() {
        try {
            if (symbols.isEmpty()) {
                throw new EmptySymbolListException("Symbol list is empty");
            }
            return symbols;
        } catch (EmptySymbolListException e) {
            System.err.println("Warning: " + e.getMessage());
            return symbols; // Return empty set for consistency
        }
    }

    public Set<String> getStates() {
        try {
            if (states.isEmpty()) {
                throw new EmptyStateListException("State list is empty");
            }
            return states;
        } catch (EmptyStateListException e) {
            System.err.println("Warning: " + e.getMessage());
            return states; // Return empty set for consistency
        }
    }

    public String getInitialState() {
        return initialState;
    }

    public Set<String> getFinalStates() {
        return finalStates;
    }

    public Map<String, Map<String, String>> getTransitions() {
        return transitions;
    }

    @Override
    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();

            // Validate symbols
            if (symbols == null) {
                throw new IllegalStateException("Symbols set is null");
            }
            sb.append("SYMBOLS ");
            if (symbols.isEmpty()) {
                throw new EmptySymbolListException("Symbol list is empty");
            }
            for (String symbol : symbols) {
                if (symbol == null || !symbol.matches("[a-zA-Z0-9]")) {
                    throw new NonAlphanumericSymbolException("Invalid symbol: " + symbol);
                }
                sb.append(symbol).append(" ");
            }
            sb.append("\n");

            // Validate states
            if (states == null) {
                throw new IllegalStateException("States set is null");
            }
            sb.append("STATES ");
            if (states.isEmpty()) {
                throw new EmptyStateListException("State list is empty");
            }
            for (String state : states) {
                if (state == null || !state.matches("[a-zA-Z0-9]+")) {
                    throw new NonAlphanumericStateException("Invalid state: " + state);
                }
                sb.append(state).append(" ");
            }
            sb.append("\n");

            // Validate initial state
            sb.append("INITIAL STATE: ");
            sb.append(initialState != null ? initialState : "undefined");
            if (initialState != null && !states.contains(initialState)) {
                throw new UndeclaredInitialStateWarningException("Initial state not declared: " + initialState);
            }
            sb.append("\n");

            // Validate final states
            if (finalStates == null) {
                throw new IllegalStateException("Final states set is null");
            }
            sb.append("FINAL STATES: ");
            for (String finalState : finalStates) {
                if (finalState == null || !finalState.matches("[a-zA-Z0-9]+")) {
                    throw new InvalidFinalStateException("Invalid final state: " + finalState);
                }
                if (!states.contains(finalState)) {
                    throw new UndeclaredFinalStateWarningException("Final state not declared: " + finalState);
                }
                sb.append(finalState).append(" ");
            }
            sb.append("\n");

            // Validate transitions
            if (transitions == null) {
                throw new IllegalStateException("Transitions map is null");
            }
            sb.append("TRANSITIONS:\n");
            for (var entry : transitions.entrySet()) {
                String symbol = entry.getKey();
                if (!symbols.contains(symbol)) {
                    throw new UndeclaredSymbolInTransitionException("Undeclared symbol in transition: " + symbol);
                }
                for (var sub : entry.getValue().entrySet()) {
                    String fromState = sub.getKey();
                    String toState = sub.getValue();
                    if (!states.contains(fromState)) {
                        throw new UndeclaredStateInTransitionException("Undeclared state in transition: " + fromState);
                    }
                    if (!states.contains(toState)) {
                        throw new UndeclaredStateInTransitionException("Undeclared state in transition: " + toState);
                    }
                    sb.append(symbol).append(" ").append(fromState).append(" ").append(toState).append("\n");
                }
            }

            return sb.toString();
        } catch (EmptySymbolListException | EmptyStateListException e) {
            System.err.println("Warning: " + e.getMessage());
            return "FSM is empty or partially defined";
        } catch (NonAlphanumericSymbolException | NonAlphanumericStateException | InvalidFinalStateException e) {
            System.err.println("Error: " + e.getMessage());
            return "Invalid FSM configuration";
        } catch (UndeclaredInitialStateWarningException | UndeclaredFinalStateWarningException e) {
            System.err.println("Warning: " + e.getMessage());
            return sb != null ? sb.toString() : "FSM with warnings";
        } catch (UndeclaredSymbolInTransitionException | UndeclaredStateInTransitionException e) {
            System.err.println("Error: " + e.getMessage());
            return "Invalid transition configuration";
        } catch (IllegalStateException e) {
            System.err.println("Error: " + e.getMessage());
            return "FSM is not properly initialized";
        } catch (Exception e) {
            System.err.println("Unexpected error generating FSM string: " + e.getMessage());
            return "Error generating FSM representation";
        }
    }
}