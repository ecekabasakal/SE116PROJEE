import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Compile {
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