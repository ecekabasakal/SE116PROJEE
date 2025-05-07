
import java.util.*;
import java.io.*;
import java.lang.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;



     class InvalidVersionException extends RuntimeException {
        public InvalidVersionException() {
            super("WARNİNG : Invalid or missing GitHub version number.");
        }

        public InvalidVersionException(String message) {
            super(message);
        }
    }

     class StartupFormatException extends RuntimeException {
        public StartupFormatException() {
            super("WARNİNG : Failed to format startup message.");
        }

        public StartupFormatException(String message) {
            super(message);
        }
    }
    class MissingSemicolonException extends RuntimeException {
        public MissingSemicolonException() {
            super("WARNİNG : Command is missing a semicolon terminator.");
        }

        public MissingSemicolonException(String message) {
            super(message);
        }
    }public class LogFileCreationException extends IOException {
        public LogFileCreationException() {
            super("WARNİNG : Failed to create log file.");
        }

        public LogFileCreationException(String message) {
            super(message);
        }
    }

    public class LogFileWriteException extends IOException {
        public LogFileWriteException() {
            super("WARNİNG : Failed to write to log file.");
        }

        public LogFileWriteException(String message) {
            super(message);
        }
    }

    public class LogAlreadyActiveException extends RuntimeException {
        public LogAlreadyActiveException() {
            super("WARNİNG : Logging is already active for another file.");
        }

        public LogAlreadyActiveException(String message) {
            super(message);
        }
    }
    public class NonAlphanumericSymbolException extends RuntimeException {
        public NonAlphanumericSymbolException() {
            super("WARNİNG : Symbol must be alphanumeric.");
        }

        public NonAlphanumericSymbolException(String message) {
            super(message);
        }
    }

    public class DuplicateSymbolWarningException extends RuntimeException {
        public DuplicateSymbolWarningException() {
            super("WARNİNG : Symbol is already declared.");
        }

        public DuplicateSymbolWarningException(String message) {
            super(message);
        }
    }

    public class EmptySymbolListException extends RuntimeException {
        public EmptySymbolListException() {
            super("WARNİNG : No symbols have been declared yet.");
        }

        public EmptySymbolListException(String message) {
            super(message);
        }
    }
    public class NonAlphanumericStateException extends RuntimeException {
        public NonAlphanumericStateException() {
            super("WARNİNG : State must be alphanumeric.");
        }

        public NonAlphanumericStateException(String message) {
            super(message);
        }
    }

    public class DuplicateStateWarningException extends RuntimeException {
        public DuplicateStateWarningException() {
            super("WARNİNG : State is already declared.");
        }

        public DuplicateStateWarningException(String message) {
            super(message);
        }
    }

    public class EmptyStateListException extends RuntimeException {
        public EmptyStateListException() {
            super("WARNİNG : No states have been declared yet.");
        }

        public EmptyStateListException(String message) {
            super(message);
        }
    }
     class InvalidInitialStateException extends RuntimeException {
        public InvalidInitialStateException() {
            super("WARNİNG : Invalid initial state specified.");
        }

        public InvalidInitialStateException(String message) {
            super(message);
        }
    }

    public class UndeclaredInitialStateWarningException extends RuntimeException {
        public UndeclaredInitialStateWarningException() {
            super("WARNİNG : Initial state was not previously declared.");
        }

        public UndeclaredInitialStateWarningException(String message) {
            super(message);
        }
    }
     class InvalidFinalStateException extends RuntimeException {
        public InvalidFinalStateException() {
            super("WARNİNG : Invalid final state specified.");
        }

        public InvalidFinalStateException(String message) {
            super(message);
        }
    }

    public class UndeclaredFinalStateWarningException extends RuntimeException {
        public UndeclaredFinalStateWarningException() {
            super("WARNİNG : Final state was not previously declared.");
        }

        public UndeclaredFinalStateWarningException(String message) {
            super(message);
        }
    }

    public class DuplicateFinalStateWarningException extends RuntimeException {
        public DuplicateFinalStateWarningException() {
            super("WARNİNG : Final state is already declared as final.");
        }

        public DuplicateFinalStateWarningException(String message) {
            super(message);
        }
    }
    public class UndeclaredSymbolInTransitionException extends RuntimeException {
        public UndeclaredSymbolInTransitionException() {
            super("WARNİNG : Symbol in transition is not declared.");
        }

        public UndeclaredSymbolInTransitionException(String message) {
            super(message);
        }
    }

    public class UndeclaredStateInTransitionException extends RuntimeException {
        public UndeclaredStateInTransitionException() {
            super("WARNİNG : State in transition is not declared.");
        }

        public UndeclaredStateInTransitionException(String message) {
            super(message);
        }
    }

    public class DuplicateTransitionOverrideException extends RuntimeException {
        public DuplicateTransitionOverrideException() {
            super("WARNİNG : Transition overrides a previously defined transition.");
        }

        public DuplicateTransitionOverrideException(String message) {
            super(message);
        }
    }
    public class PrintFileCreationException extends IOException {
        public PrintFileCreationException() {
            super("WARNİNG : Failed to create print output file.");
        }

        public PrintFileCreationException(String message) {
            super(message);
        }
    }

    public class PrintFileWriteException extends IOException {
        public PrintFileWriteException() {
            super("WARNİNG : Failed to write to print output file.");
        }

        public PrintFileWriteException(String message) {
            super(message);
        }
    }

     class InvalidPrintFilenameException extends RuntimeException {
        public InvalidPrintFilenameException() {
            super("WARNİNG : Invalid or empty print filename specified.");
        }

        public InvalidPrintFilenameException(String message) {
            super(message);
        }
    }
    public class CompileFileCreationException extends IOException {
        public CompileFileCreationException() {
            super("WARNİNG : Failed to create compiled FSM file.");
        }

        public CompileFileCreationException(String message) {
            super(message);
        }
    }

    public class CompileSerializationException extends IOException {
        public CompileSerializationException() {
            super("WARNİNG : Failed to serialize FSM to binary file.");
        }

        public CompileSerializationException(String message) {
            super(message);
        }
    }

     class InvalidCompileFilenameException extends RuntimeException {
        public InvalidCompileFilenameException() {
            super("WARNİNG : Invalid or empty compile filename specified.");
        }

        public InvalidCompileFilenameException(String message) {
            super(message);
        }
    }
    public class ClearOperationFailureException extends RuntimeException {
        public ClearOperationFailureException() {
            super("WARNİNG : Failed to clear FSM components.");
        }

        public ClearOperationFailureException(String message) {
            super(message);
        }
    }
    public class LoadFileNotFoundException extends IOException {
        public LoadFileNotFoundException() {
            super("WARNİNG : Specified load file not found.");
        }

        public LoadFileNotFoundException(String message) {
            super(message);
        }
    }

    public class LoadFileFormatException extends IOException {
        public LoadFileFormatException() {
            super("WARNİNG : Load file content is in an invalid format.");
        }

        public LoadFileFormatException(String message) {
            super(message);
        }
    }
     class InvalidInputSymbolException extends RuntimeException {
        public InvalidInputSymbolException() {
            super("WARNİNG : Input string contains an undeclared symbol.");
        }

        public InvalidInputSymbolException(String message) {
            super(message);
        }
    }

     class NoTransitionDefinedException extends RuntimeException {
        public NoTransitionDefinedException() {
            super("WARNİNG : No transition defined for current state and symbol.");
        }

        public NoTransitionDefinedException(String message) {
            super(message);
        }
    }

    public class EmptyInputStringException extends RuntimeException {
        public EmptyInputStringException() {
            super("WARNİNG : Input string is empty.");
        }

        public EmptyInputStringException(String message) {
            super(message);
        }
    }
    public class CommandLineFileNotFoundException extends IOException {
        public CommandLineFileNotFoundException() {
            super("WARNİNG : Command-line specified file not found.");
        }

        public CommandLineFileNotFoundException(String message) {
            super(message);
        }
    }

    public class CommandLineFileAccessException extends IOException {
        public CommandLineFileAccessException() {
            super("WARNİNG : Unable to access command-line specified file.");
        }

        public CommandLineFileAccessException(String message) {
            super(message);
        }
    }

    public class CommandLineExecutionException extends RuntimeException {
        public CommandLineExecutionException() {
            super("WARNİNG : Error executing commands from command-line file.");
        }

        public CommandLineExecutionException(String message) {
            super(message);
        }
    }
     class InvalidCommandSyntaxException extends IOException{
        public InvalidCommandSyntaxException(){
            super("WARNİNG : Error executing from syntax ");
        }
        public InvalidCommandSyntaxException(String message){
            super(message);
        }
    }
     class LoadCommandExecution extends IOException{
        public LoadCommandExecution(){
            super("WARNİNG : Error executing from command");
        }
        public LoadCommandExecution(String message){
            super(message);
        }
    }
    class States {
        private Set<String> states = new HashSet<>();
        private String initialState;
        private Set<String> finalStates = new HashSet<>();

        public States() {

        }

        private boolean isAlphanumeric(String s) {
            return s.matches("[a-zA-Z0-9]+");
        }

        public void processCommand(String commandLine) throws NonAlphanumericStateException, DuplicateStateWarningException, EmptyStateListException, InvalidInitialStateException, UndeclaredInitialStateWarningException, InvalidFinalStateException, UndeclaredFinalStateWarningException, DuplicateFinalStateWarningException {
            String[] tokens = commandLine.trim().split("\\s+");
            if (tokens.length == 0) return;

            String command = tokens[0].toUpperCase();

            switch (command) {
                case "STATES":
                    if (tokens.length == 1) {
                        printStates();
                    } else {
                        for (int i = 1; i < tokens.length; i++) {
                            String state = tokens[i];
                            if (isAlphanumeric(state)) {
                                addState(state);
                            } else {
                                throw new NonAlphanumericStateException("Warning: State \"" + state + "\" is not alphanumeric and will be ignored.");
                            }
                        }
                    }
                    break;

                case "INITIAL-STATE":
                    if (tokens.length < 2) {
                        throw new InvalidInitialStateException("Warning: INITIAL-STATE command requires a state name.");
                    } else {
                        String initialState = tokens[1];
                        if (isAlphanumeric(initialState)) {
                            setInitialState(initialState);
                        } else {
                            throw new InvalidInitialStateException("Warning: Initial state \"" + initialState + "\" is not alphanumeric.");
                        }
                    }
                    break;

                case "FINAL-STATES":
                    if (tokens.length < 2) {
                        throw new InvalidFinalStateException("Warning: FINAL-STATES command requires at least one state.");
                    } else {
                        for (int i = 1; i < tokens.length; i++) {
                            String finalState = tokens[i];
                            if (isAlphanumeric(finalState)) {
                                addFinalState(finalState);
                            } else {
                                throw new InvalidFinalStateException("Warning: Final state \"" + finalState + "\" is not alphanumeric and will be ignored.");
                            }
                        }
                    }
                    break;

                default:
                    System.out.println("Warning: Unknown command \"" + command + "\".");
            }
        }

        private void addFinalState(String finalState) {
            if (!states.contains(finalState)) {
                throw new UndeclaredFinalStateWarningException("Final state not declared: " + finalState);
            }
            if (finalStates.contains(finalState)) {
                throw new DuplicateFinalStateWarningException("Final state already declared: " + finalState);
            }
            finalStates.add(finalState);
        }

        private void setInitialState(String initialState) {
            if (!states.contains(initialState)) {
                throw new UndeclaredInitialStateWarningException("Initial state not declared: " + initialState);
            }
            this.initialState = initialState;
        }

        private void printStates() {
            if (states.isEmpty()) {
                throw new EmptyStateListException();
            }
            System.out.println("States: " + states);
        }

        private void addState(String state) {
            if (states.contains(state)) {
                throw new DuplicateStateWarningException("State already declared: " + state);
            }
            states.add(state);
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

        // New method to check if a state is final
        public boolean isFinalState(String state) {
            return finalStates.contains(state);
        }

        public void clear() {
            states.clear();
            initialState = null;
            finalStates.clear();
        }

    }
    class CommandProcessor {
        public void processCommand(String command) throws MissingSemicolonException  {

            if (!command.contains(";")) {
                throw new MissingSemicolonException();
            }

            int semicolonIndex = command.indexOf(';');
            String processedCommand = command.substring(0, semicolonIndex).trim();


            if (processedCommand.isEmpty()) {
                return;
            }
            if (command.equalsIgnoreCase("EXIT")) {
                System.out.println("TERMINATED BY USER");
                System.exit(0);
            } else {
                System.out.println("Processing command: " + command);
            }
        }
    }
    class Compile {
        private FSM fsm;

        public Compile(FSM fsm) {
            this.fsm = fsm;
        }

        public void handleCompile(String filename) {
            try {
                if (filename == null || filename.trim().isEmpty()) {
                    throw new InvalidCompileFilenameException("Filename cannot be null or empty");
                }
                if (!isValidFilename(filename)) {
                    throw new InvalidCompileFilenameException("Invalid filename format: " + filename);
                }

                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                    oos.writeObject(fsm);
                    oos.flush(); // Ensure all data is written
                    System.out.println("FSM compiled and saved to " + filename);
                } catch (FileNotFoundException e) {

                    throw new CompileFileCreationException("Cannot create file: " + filename + " - " + e.getMessage());
                } catch (IOException e) {

                    throw new CompileSerializationException("Error serializing FSM to file: " + filename + " - " + e.getMessage());
                }
            } catch (InvalidCompileFilenameException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (CompileFileCreationException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (CompileSerializationException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) {

                System.err.println("Unexpected error while compiling FSM: " + e.getMessage());
            }
        }


        private boolean isValidFilename(String filename) {

            return filename.matches("[a-zA-Z0-9.-][a-zA-Z0-9.-]*");
        }
    }
    class Print {
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

    class SymbolManager {
        private Set<String> symbols = new HashSet<>();
        private States states;
        private Transition transitionManager;


        public SymbolManager(States states, Transition transitionManager) {
            this.states = states;
            this.transitionManager = transitionManager;
        }

        public void handleSymbolsCommand(String command) throws NonAlphanumericSymbolException, DuplicateSymbolWarningException, EmptySymbolListException {
            try {
                String[] symbolArray = command.split("\s+");

                if (symbolArray.length == 0) {
                    if (symbols.isEmpty()) {
                        throw new EmptySymbolListException();
                    }
                    System.out.println("Current symbols: " + symbols);
                    return;
                }

                for (String symbol : symbolArray) {
                    if (!symbol.matches("[a-zA-Z0-9]+")) {
                        throw new NonAlphanumericSymbolException("Warning: invalid symbol " + symbol);
                    }

                    String normalizedSymbol = symbol.toLowerCase();

                    if (symbols.contains(normalizedSymbol)) {
                        throw new DuplicateSymbolWarningException("Warning: symbol " + symbol + " already declared.");
                    } else {
                        symbols.add(normalizedSymbol);
                        System.out.println("Symbol " + symbol + " added.");
                    }
                }
            } catch (NonAlphanumericSymbolException | DuplicateSymbolWarningException | EmptySymbolListException e) {
                throw e;
            }

            //bakılacak
            public void clear() {
                // Semboller
                if (symbols != null) {
                    symbols.clear();
                }

                // StatesManager varsa onu temizle
                if (states != null) {
                    States.clear();
                }

                // TransitionManager varsa onu da temizle
                if (transitionManager != null) {
                    Transition.clear();
                }

                System.out.println("FSM cleared.");

            }
        }
    }

    class FSM implements Serializable {
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
            StringBuilder sb = new StringBuilder();

            try {

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


                sb.append("INITIAL STATE: ");
                sb.append(initialState != null ? initialState : "undefined");
                if (initialState != null && !states.contains(initialState)) {
                    throw new UndeclaredInitialStateWarningException("Initial state not declared: " + initialState);
                }
                sb.append("\n");


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
    class Transition {
        private Set<String> validSymbols;
        private Set<String> validStates;
        public Map<String, Map<String, Transition>> transitionTable;

        public Transition(Set<String> validSymbols, Set<String> validStates) {
            this.validSymbols = new HashSet<>();
            for (String symbol : validSymbols) {
                this.validSymbols.add(symbol.toUpperCase());
            }
            this.validStates = new HashSet<>();
            for (String state : validStates) {
                this.validStates.add(state.toUpperCase());
            }
            this.transitionTable = new HashMap<>();
        }

        //Bakılcak
        public Transition(String symbol, String currentState, String nextState) {

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
                    transitionTable.get(currentState).put(symbol, nextState);
                }
            } catch (UndeclaredSymbolInTransitionException | UndeclaredStateInTransitionException | DuplicateTransitionOverrideException e) {
                throw e;
            }
        }

        public String getTransition(String currentState, String symbol) {
            Map<String, String> row = transitionTable.get(currentState.toUpperCase());
            if (row != null) {
                return row.get(symbol.toUpperCase());
            }
            return null;
        }
        public void printTransitions() {
            StringBuilder output = new StringBuilder();
            boolean first = true;
            for (String state : transitionTable.keySet()) {
                for (Map.Entry<String, String> entry : transitionTable.get(state).entrySet()) {
                    if (!first) {
                        output.append(", ");
                    }
                    output.append(entry.getKey()).append(" ").append(state).append(" ").append(entry.getValue());
                    first = false;
                }
            }
            System.out.println(output.toString());
        }

        public void clear() {
            transitionTable.clear();
            validSymbols.clear();
            validStates.clear();
        }
        public Map<String, Map<String, String>> getTransitionTable() {
            return transitionTable;
        }

        public String getNextState() {
            throw new UnsupportedOperationException("Unimplemented method 'getNextState'");
        }
    }

    class FSMExecutor {
        private States states;
        private Transition transitions;
        private Set<String> symbols;

        public FSMExecutor(States states, Transition transitions, Set<String> symbols) {
            this.states = states;
            this.transitions = transitions;
            this.symbols = symbols;
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

                if (!symbols.contains(symbol)) {
                    System.out.println("Error: Invalid symbol " + symbol);
                    return;
                }

                Transition t = Transition.getTransition(currentState, symbol);
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


    class Load {
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
                    Transition transitionManager = new Transition(fsm.symbols, fsm.states);
                    transitionManager.processTransitionsCommand(fullTransitionCommand.toString().trim());

                    fsm.transitions.clear();
                    Map<String, Map<String, String>> transitionTable = transitionManager.getTransitionTable();
                    for (String fromState : transitionTable.keySet()) {
                        Map<String, String> innerMap = transitionTable.get(fromState);
                        for (String symbol : innerMap.keySet()) {
                            String nextState = innerMap.get(symbol);
                            fsm.transitions.putIfAbsent(symbol, new HashMap<>());
                            fsm.transitions.get(symbol).put(fromState, nextState);
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



    class LogManager {
        private BufferedWriter logWriter;
        private boolean isLogging = false;

        public void startLogging(String filename) throws LogFileCreationException, LogAlreadyActiveException {
            if (isLogging) {
                throw new LogAlreadyActiveException();
            }

            try {
                logWriter = new BufferedWriter(new FileWriter(filename, false));
                isLogging = true;
                System.out.println("Started logging to: " + filename);
            } catch (IOException e) {
                throw new LogFileCreationException("Failed to create or open log file: " + filename);
            }
        }

        public void stopLogging() throws LogFileWriteException {
            if (isLogging) {
                try {
                    logWriter.close();
                    isLogging = false;
                    System.out.println("STOPPED LOGGING");
                } catch (IOException e) {
                    throw new LogFileWriteException("Failed to close log file.");
                }
            } else {
                System.out.println("LOGGING was not enabled");
            }
        }

        public void logCommand(String command) throws LogFileWriteException {
            if (isLogging) {
                try {
                    logWriter.write(command + "\n");
                    logWriter.flush(); // Ensure immediate write
                } catch (IOException e) {
                    throw new LogFileWriteException("Failed to write command to log file.");
                }
            }
        }

        public void handleLogCommand(String command) throws LogFileCreationException, LogAlreadyActiveException {
            String[] commandParts = command.split("\\s+");
            if (commandParts.length == 1) {
                try {
                    stopLogging();
                } catch (LogFileWriteException e) {
                    System.out.println(e.getMessage());
                }
            } else if (commandParts.length == 2) {
                String filename = commandParts[1];
                startLogging(filename);
            } else {
                System.out.println("Error: Invalid LOG command format.");
            }
        }
    }
    private static void processCommand(String command, Print print, Load load, Clear clear, Compile compile, CommandProcessor processor) throws Exception {
        String[] tokens = command.split("\\s+");
        String mainCommand = tokens[0].toUpperCase();
        String[] argsRest = java.util.Arrays.copyOfRange(tokens, 1, tokens.length);

        switch (mainCommand) {
            case "PRINT":
                print.handlePrint(argsRest);
                break;
            case "LOAD":
                if (argsRest.length == 0) {
                    throw new InvalidCommandSyntaxException("Missing filename for LOAD command");
                }
                load.handleLoad(argsRest[0]);
                break;
            case "CLEAR":
                clear.handleClear();
                break;
            case "COMPILE":
                if (argsRest.length == 0) {
                    throw new InvalidCommandSyntaxException("Missing filename for COMPILE command");
                }
                compile.handleCompile(argsRest[0]);
                break;
            default:
                processor.processCommand(command);
        }
    }
    private static boolean isValidVersion(String version) {
        return version != null && version.matches("\\d+\\.\\d+\\.\\d+");
    }
    private static boolean isValidFilename(String filename) {
        return filename.matches("[a-zA-Z0-9._-][a-zA-Z0-9._-]*");
    }
    private static boolean isValidCommand(String command) {
        return command != null && !command.isEmpty() && command.matches("[a-zA-Z0-9\\s-]*");
    }
    public class FSMMAINN{
        public static void main(String[] args) {
            try {
                FSMMAINN fsm = new FSMMAINN();
                Print print = new Print(fsm);
                Clear clear = new clear(fsm);
                Load load = new Load(fsm);
                Compile compile = new Compile(fsm);
                CommandProcessor processor = new CommandProcessor();
                String versionNo = "1.0.0";
                if (!isValidVersion(versionNo)) {
                    throw new InvalidVersionException("Invalid version number: " + versionNo);
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String currentDateTime;
                try {
                    currentDateTime = LocalDateTime.now().format(formatter);
                } catch (DateTimeParseException | IllegalArgumentException e) {
                    throw new StartupFormatException("Failed to format date and time: " + e.getMessage());
                }
                System.out.println("FSM DESIGNER " + versionNo);
                System.out.println("Current date and time: " + currentDateTime);
                if (args.length > 0) {
                    String filePath = args[0];
                    if (filePath == null || filePath.trim().isEmpty()) {
                        throw new CommandLineFileNotFoundException("Command-line filename cannot be null or empty");
                    }
                    if (!isValidFilename(filePath)) {
                        throw new CommandLineFileNotFoundException("Invalid command-line filename format: " + filePath);
                    }

                    File file = new File(filePath);
                    try (Scanner fileScanner = new Scanner(file)) {
                        int lineNumber = 0;
                        while (fileScanner.hasNextLine()) {
                            lineNumber++;
                            String line = fileScanner.nextLine().trim();
                            if (line.startsWith(";") || line.isEmpty()) {
                                continue;
                            }
                            if (line.startsWith("?")) {
                                line = line.substring(1).trim();
                            }
                            int semicolonIndex = line.indexOf(';');
                            if (semicolonIndex == -1) {
                                throw new MissingSemicolonException("Command missing semicolon on line " + lineNumber + ": " + line);
                            }
                            line = line.substring(0, semicolonIndex).trim();
                            if (!isValidCommand(line)) {
                                throw new InvalidCommandSyntaxException("Invalid command syntax on line " + lineNumber + ": " + line);
                            }
                            try {
                                processCommand(line, print, load, clear, compile, processor);
                            } catch (Exception e) {
                                throw new LoadCommandExecution("Error on line " + lineNumber + ": " + e.getMessage());
                            }
                        }
                    } catch (FileNotFoundException e) {
                        throw new CommandLineFileNotFoundException("File not found: " + filePath);
                    } catch (SecurityException e) {
                        throw new CommandLineFileAccessException("Cannot access file: " + filePath + " - " + e.getMessage());
                    }
                }
                try (Scanner scanner = new Scanner(System.in)) {
                    while (true) {
                        System.out.print("? ");
                        String command = scanner.nextLine().trim();
                        if (command.startsWith(";") || command.isEmpty()) {
                            continue;
                        }
                        if (command.startsWith("?")) {
                            command = command.substring(1).trim();
                        }
                        int semicolonIndex = command.indexOf(';');
                        if (semicolonIndex == -1) {
                            throw new MissingSemicolonException("Command missing semicolon: " + command);
                        }
                        command = command.substring(0, semicolonIndex).trim();
                        if (!isValidCommand(command)) {
                            throw new InvalidCommandSyntaxException("Invalid command syntax: " + command);
                        }
                        processCommand(command, print, load, clear, compile, processor);
                    }
                }
            } catch (InvalidVersionException e) {
                System.err.println("Startup Error: " + e.getMessage());
                System.exit(1);
            } catch (StartupFormatException e) {
                System.err.println("Startup Error: " + e.getMessage());
                System.exit(1);
            } catch (CommandLineFileNotFoundException e) {
                System.err.println("Error: " + e.getMessage());
                System.exit(1);
            } catch (CommandLineFileAccessException e) {
                System.err.println("Error: " + e.getMessage());
                System.exit(1);
            } catch (MissingSemicolonException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (InvalidCommandSyntaxException e) {
                System.err.println("Error: " + e.getMessage());
            } catch (LoadCommandExecution e) {
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error: " + e.getMessage());
                System.exit(1);
            }
        }
    }




