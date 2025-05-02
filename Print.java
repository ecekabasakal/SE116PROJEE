import java.io.*;
import java.util.*;

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
            System.out.println("FSM written to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
