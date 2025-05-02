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

    public void processTransitionsCommand(String command) throws UndeclaredSymbolInTransitionException, UndeclaredStateInTransitionException, DuplicateTransitionOverrideException {
        try {
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

                if (!validSymbols.contains(symbol)) {
                    throw new UndeclaredSymbolInTransitionException("Error: invalid symbol $" + symbol + "$");
                }
                if (!validStates.contains(currentState)) {
                    throw new UndeclaredStateInTransitionException("Error: invalid state $" + currentState + "$");
                }
                if (!validStates.contains(nextState)) {
                    throw new UndeclaredStateInTransitionException("Error: invalid state $" + nextState + "$");
                }
                if (transitionTable.containsKey(currentState) && transitionTable.get(currentState).containsKey(symbol)) {
                    throw new DuplicateTransitionOverrideException("Warning: transition already exists for <" + symbol + ", " + currentState + ">");
                }

                transitionTable.putIfAbsent(currentState, new HashMap<>());
                transitionTable.get(currentState).put(symbol, new Transition(symbol, currentState, nextState));
            }
        } catch (UndeclaredSymbolInTransitionException | UndeclaredStateInTransitionException | DuplicateTransitionOverrideException e) {
            throw e;         }
    }

    public Transition getTransition(String currentState, String symbol) {
        Map<String, Transition> row = transitionTable.get(currentState.toUpperCase());
        if (row != null) {
            return row.get(symbol.toUpperCase());
        }
        return null;
    }

    public void printTransitions() {
        StringBuilder output = new StringBuilder();
        boolean first = true;
        for (String state : transitionTable.keySet()) {
            for (Transition t : transitionTable.get(state).values()) {
                if (!first) {
                    output.append(", ");
                }
                output.append(t);
                first = false;
            }
        }
        System.out.println(output.toString());
    }
}