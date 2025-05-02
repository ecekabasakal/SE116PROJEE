import java.util.*;

public class TransitionManager {
    private Set<String> validSymbols;
    private Set<String> validStates;
    private Map<String, Map<String, Transition>> transitionTable;

    public TransitionManager(Set<String> validSymbols, Set<String> validStates) {
        this.validSymbols = new HashSet<>();
        for (String symbol : validSymbols)
            this.validSymbols.add(symbol.toUpperCase());

        this.validStates = new HashSet<>();
        for (String state : validStates)
            this.validStates.add(state.toUpperCase());

        this.transitionTable = new HashMap<>();
    }

    public void processTransitionsCommand(String command) {
        // Remove "TRANSITIONS" keyword and split by commas
        String[] parts = command.substring("TRANSITIONS".length()).trim().split(",");

        for (String part : parts) {
            String[] tokens = part.trim().split("\\s+");
            if (tokens.length != 3) {
                System.out.println("Invalid transition format: " + part.trim());
                continue;
            }

            String symbol = tokens[0].toUpperCase();
            String currentState = tokens[1].toUpperCase();
            String nextState = tokens[2].toUpperCase();

            boolean hasError = false;

            if (!validSymbols.contains(symbol)) {
                System.out.println("Error: invalid symbol " + symbol);
                hasError = true;
            }
            if (!validStates.contains(currentState)) {
                System.out.println("Error: invalid state " + currentState);
                hasError = true;
            }
            if (!validStates.contains(nextState)) {
                System.out.println("Error: invalid state " + nextState);
                hasError = true;
            }

            if (hasError) continue;

            // Insert or override transition
            transitionTable.putIfAbsent(currentState, new HashMap<>());
            transitionTable.get(currentState).put(symbol, new Transition(symbol, currentState, nextState));
        }
    }

    public Transition getTransition(String currentState, String symbol) {
        Map<String, Transition> row = transitionTable.get(currentState.toUpperCase());
        if (row != null) {
            return row.get(symbol.toUpperCase());
        }
        return null;
    }

    public void printTransitions() {
        for (String state : transitionTable.keySet()) {
            for (Transition t : transitionTable.get(state).values()) {
                System.out.println(t);
            }
        }
    }
}
