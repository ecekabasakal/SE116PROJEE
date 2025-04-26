import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogManager {
    private BufferedWriter logWriter;
    private boolean isLogging = false;

    
    public void startLogging(String filename) {
        try {
            if (isLogging) {
                logWriter.close();  
            }
            logWriter = new BufferedWriter(new FileWriter(filename, false));  
            isLogging = true;
            System.out.println("Started logging to: " + filename);
        } catch (IOException e) {
            System.out.println("Error: Unable to start logging to " + filename);
        }
    }
    public void stopLogging() {
        if (isLogging) {
            try {
                logWriter.close();
                isLogging = false;
                System.out.println("STOPPED LOGGING");
            } catch (IOException e) {
                System.out.println("Error: Unable to stop logging.");
            }
        } else {
            System.out.println("LOGGING was not enabled");
        }
    }
}