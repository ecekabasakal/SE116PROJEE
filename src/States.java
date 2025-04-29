import java.util.*;
public class States {

    public class States {
        private Set<String> states;
        private String initialState;
        private Set<String> finalStates;

        public States() {
            states = new LinkedHashSet<>();
            finalStates = new LinkedHashSet<>();
            initialState = null;
        }

        public void addState(String stateName) {
            String state = stateName.toUpperCase();
            if (states.contains(state)) {
                System.out.println("Warning: State " + state + " was already declared.");
            } else {
                states.add(state);
                if (initialState == null) {
                    initialState = state;
                }
            }
        }

        public void setInitialState(String stateName) {
            String state = stateName.toUpperCase();
            if (!states.contains(state)) {
                System.out.println("Warning: Initial state " + state + " was not previously declared. Adding it.");
                states.add(state);
            }
            initialState = state;
        }

        public void addFinalState(String stateName) {
            String state = stateName.toUpperCase();
            if (!states.contains(state)) {
                System.out.println("Warning: Final state " + state + " was not previously declared. Adding it.");
                states.add(state);
            }
            if (finalStates.contains(state)) {
                System.out.println("Warning: Final state " + state + " was already declared as a final state.");
            }
            finalStates.add(state);
        }

        public Set<String> getStates() {
            return states;
        }

        public String getInitialState() {
            return initialState;
        }

        public Set<String> getFinalStates() {
            return finalStates;
        }

        public void clear() {
            states.clear();
            finalStates.clear();
            initialState = null;
        }

        public void printStates() {
            System.out.println("States: " + states);
            System.out.println("Initial State: " + (initialState != null ? initialState : "None"));
            System.out.println("Final States: " + finalStates);
        }
    }

}
