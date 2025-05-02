import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize FSM and components
            FSM fsm = new FSM();
            Print print = new Print(fsm);
            Clear clear = new Clear(fsm);
            Load load = new Load(fsm);
            Compile compile = new Compile(fsm);
            CommandProcessor processor = new CommandProcessor();

            // Validate version number (simulated GitHub fetch)
            String versionNo = "1.0.0"; // Hardcoded for now
            if (!isValidVersion(versionNo)) {
                throw new InvalidVersionException("Invalid version number: " + versionNo);
            }

            // Format startup message
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String currentDateTime;
            try {
                currentDateTime = LocalDateTime.now().format(formatter);
            } catch (DateTimeParseException | IllegalArgumentException e) {
                throw new StartupFormatException("Failed to format date and time: " + e.getMessage());
            }

            // Print startup message (FR1)
            System.out.println("FSM DESIGNER " + versionNo);
            System.out.println("Current date and time: " + currentDateTime);

            // Handle command-line file input (FR15)
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

                        // Check for semicolon
                        int semicolonIndex = line.indexOf(';');
                        if (semicolonIndex == -1) {
                            throw new MissingSemicolonException("Command missing semicolon on line " + lineNumber + ": " + line);
                        }
                        line = line.substring(0, semicolonIndex).trim();

                        // Validate command syntax
                        if (!isValidCommand(line)) {
                            throw new InvalidCommandSyntaxException("Invalid command syntax on line " + lineNumber + ": " + line);
                        }

                        // Process command
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

            // Interactive command loop
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

                    // Check for semicolon
                    int semicolonIndex = command.indexOf(';');
                    if (semicolonIndex == -1) {
                        throw new MissingSemicolonException("Command missing semicolon: " + command);
                    }
                    command = command.substring(0, semicolonIndex).trim();

                    // Validate command syntax
                    if (!isValidCommand(command)) {
                        throw new InvalidCommandSyntaxException("Invalid command syntax: " + command);
                    }

                    // Process command
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

    // Helper method to process commands
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

    // Helper method to validate version number
    private static boolean isValidVersion(String version) {
        // Simulate GitHub version validation (e.g., semantic versioning)
        return version != null && version.matches("\\d+\\.\\d+\\.\\d+");
    }

    // Helper method to validate filename
    private static boolean isValidFilename(String filename) {
        return filename.matches("[a-zA-Z0-9._-][a-zA-Z0-9._-]*");
    }

    // Helper method to validate command syntax
    private static boolean isValidCommand(String command) {
        return command != null && !command.isEmpty() && command.matches("[a-zA-Z0-9\\s-]*");
    }
}