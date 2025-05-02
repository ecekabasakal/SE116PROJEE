import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogManager {
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