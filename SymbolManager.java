import java.util.HashSet;
import java.util.Set;

public class SymbolManager {
    private Set<String> symbols = new HashSet<>();

    public void handleSymbolsCommand(String command) {
        String[] symbolArray = command.split("\\s+");

        if (symbolArray.length == 0) {
            System.out.println("Current symbols: " + symbols);
            return;
        }

        for (String symbol : symbolArray) {
            if (!symbol.matches("[a-zA-Z0-9]+")) {
                System.out.println("Warning: invalid symbol " + symbol);
                continue;
            }
            
        
            String normalizedSymbol = symbol.toLowerCase();

            if (symbols.contains(normalizedSymbol)) {
                System.out.println("Warning: symbol " + symbol + " already declared.");
            } else {
                symbols.add(normalizedSymbol);  
                System.out.println("Symbol " + symbol + " added.");
            }
        }
    }
}