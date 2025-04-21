
public class CommandProcessor {
    public void processCommand(String command) {
        
        int semicolonIndex = command.indexOf(';');
        if (semicolonIndex != -1) {
            command = command.substring(0, semicolonIndex).trim();
        }
        
        if (command.equalsIgnoreCase("EXIT")) {
            System.out.println("TERMINATED BY USER");
            System.exit(0);  
        } else {
            System.out.println("Processing command: " + command);
        }
    }

}