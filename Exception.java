@ -0,0 +1,32 @@
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
    }
}