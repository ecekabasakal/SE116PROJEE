import java.util.*;

public class FSMExecutor {
    private States states;
    private TransitionManager transitions;

    public FSMExecutor(States states, TransitionManager transitions) {
        this.states = states;
        this.transitions = transitions;
    }

    public void execute(String input) {
        input = input.trim().toUpperCase();
        if (input.isEmpty()) {
            System.out.println("Error: Input string is empty.");
            return;
        }

        String currentState = states.getInitialState();
        if (currentState == null) {
            System.out.println("Error: Initial state is not set.");
            return;
        }

        List<String> stateSequence = new ArrayList<>();
        stateSequence.add(currentState);

        for (char ch : input.toCharArray()) {
            String symbol = String.valueOf(ch).toUpperCase();

            if (!states.getSymbols().contains(symbol)) {
                System.out.println("Error: Invalid symbol " + symbol);
                return;
            }

            Transition t = transitions.getTransition(currentState, symbol);
            if (t == null) {
                System.out.println(String.join(" ", stateSequence) + " NO");
                return;
            }

            currentState = t.getNextState();
            stateSequence.add(currentState);
        }

        String result = states.isFinalState(currentState) ? "YES" : "NO";
        System.out.println(String.join(" ", stateSequence) + " " + result);
    }
}
