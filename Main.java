import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main{
       public static void main(String[] args) {
        FSM fsm = new FSM();

        
        //buraya transitonslar gelicek (örnek olarak)
        //fsm.symbols.addAll(java.util.List.of("0", "1"));
        // fsm.states.addAll(java.util.List.of("Q0", "Q1"));

        Print print = new Print(fsm);
        Clear clear = new Clear(fsm);
        Load load = new Load(fsm);
        Compile compile = new Compile(fsm);
    
  
        CommandProcessor processor = new CommandProcessor();
        Scanner scanner = new Scanner(System.in);
        String versionNo = "1.0.0";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = LocalDateTime.now().format(formatter);

        System.out.println("FSM DESIGNER " + versionNo);
        System.out.println("Current date and time: " + currentDateTime);
        
        if (args.length > 0) {
            String filePath = args[0];
            try (Scanner fileScanner = new Scanner(new java.io.File(filePath))) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine().trim();
                    if (line.startsWith(";") || line.isEmpty()) continue;
                    if (line.startsWith("?")) line = line.substring(1).trim();

                    int semicolonIndex = line.indexOf(';');
                    if (semicolonIndex != -1) {
                        line = line.substring(0, semicolonIndex).trim();
                    }

                    String[] tokens = line.split("\\s+");
                    String mainCommand = tokens[0].toUpperCase();
                    String[] argsRest = java.util.Arrays.copyOfRange(tokens, 1, tokens.length);

                    switch (mainCommand) {
                        case "PRINT":
                            print.handlePrint(argsRest);
                            break;
                        case "LOAD":
                            if (argsRest.length > 0) load.handleLoad(argsRest[0]);
                            else System.out.println("Missing filename for LOAD.");
                            break;
                        case "CLEAR":
                            clear.handleClear();
                            break;
                        case "COMPILE":
                            if (argsRest.length > 0) compile.handleCompile(argsRest[0]);
                            else System.out.println("Missing filename for COMPILE.");
                            break;
                        default:
                            processor.processCommand(line); // fallback
                    }
                }
            } catch (java.io.FileNotFoundException e) {
                System.out.println("Error: Cannot open file " + filePath);
            }
        }
        
        while (true) {
            System.out.print("? ");
            String command = scanner.nextLine().trim();
            if (command.startsWith(";") || command.isEmpty()) {
                continue;
            }

            int semicolonIndex = command.indexOf(';');
            if (semicolonIndex != -1) {
                command = command.substring(0, semicolonIndex).trim();
            }

            if (command.startsWith("?")) {
                command = command.substring(1).trim();
            }

            String[] tokens = command.split("\\s+");
            String mainCommand = tokens[0].toUpperCase();
            String[] argsRest = java.util.Arrays.copyOfRange(tokens, 1, tokens.length);

            switch (mainCommand) {
                case "PRINT":
                    print.handlePrint(argsRest);
                    break;
                case "LOAD":
                    if (argsRest.length > 0) load.handleLoad(argsRest[0]);
                    else System.out.println("Missing filename for LOAD.");
                    break;
                case "CLEAR":
                    clear.handleClear();
                    break;
                case "COMPILE":
                    if (argsRest.length > 0) compile.handleCompile(argsRest[0]);
                    else System.out.println("Missing filename for COMPILE.");
                    break;
                default:
            processor.processCommand(command);
        }


    }
