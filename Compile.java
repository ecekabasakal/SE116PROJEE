import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Compile {
    
    private FSM fsm;

    public Compile(FSM fsm) {
        this.fsm = fsm;
    }

    public void handleCompile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(fsm);
            System.out.println("FSM compiled and saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error compiling FSM: " + e.getMessage());
        }
    }
}


