
public class CommandProcessor {
    public void processCommand(String command) throws MissingSemicolonException  {
        
        if (!command.contains(";")) {
            throw new MissingSemicolonException();
        }

        // Extract command before semicolon and trim
        int semicolonIndex = command.indexOf(';');
        String processedCommand = command.substring(0, semicolonIndex).trim();

        // Ignore comments (lines starting with semicolon)
        if (processedCommand.isEmpty()) {
            return; // Comment line, no processing needed
        }
        if (command.equalsIgnoreCase("EXIT")) {
            System.out.println("TERMINATED BY USER");
            System.exit(0);  
        } else {
            System.out.println("Processing command: " + command);
        }
    }
}