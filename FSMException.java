import java.io.IOException;

public class Exception{
    public class InvalidVersionException extends RuntimeException {
        public InvalidVersionException() {
            super("WARNİNG : Invalid or missing GitHub version number.");
        }
    
        public InvalidVersionException(String message) {
            super(message);
        }
    }
    
    public class StartupFormatException extends RuntimeException {
        public StartupFormatException() {
            super("WARNİNG : Failed to format startup message.");
        }
    
        public StartupFormatException(String message) {
            super(message);
        }
    }
    public class MissingSemicolonException extends RuntimeException {
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
    public class InvalidInitialStateException extends RuntimeException {
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
    public class InvalidFinalStateException extends RuntimeException {
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
    
    public class InvalidPrintFilenameException extends RuntimeException {
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
    
    public class InvalidCompileFilenameException extends RuntimeException {
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
    public class InvalidInputSymbolException extends RuntimeException {
        public InvalidInputSymbolException() {
            super("WARNİNG : Input string contains an undeclared symbol.");
        }
    
        public InvalidInputSymbolException(String message) {
            super(message);
        }
    }
    
    public class NoTransitionDefinedException extends RuntimeException {
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
}