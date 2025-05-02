import java.util.HashSet;
import java.util.Set;

public class SymbolManager {
    private Set<String> symbols = new HashSet<>();

    public void handleSymbolsCommand(String command) throws NonAlphanumericSymbolException, DuplicateSymbolWarningException, EmptySymbolListException {
        try {
            String[] symbolArray = command.split("\\s+");

            if (symbolArray.length == 0) {
                if (symbols.isEmpty()) {
                    throw new EmptySymbolListException();
                }
                System.out.println("Current symbols: " + symbols);
                return;
            }

            for (String symbol : symbolArray) {
                if (!symbol.matches("[a-zA-Z0-9]+")) {
                    throw new NonAlphanumericSymbolException("Warning: invalid symbol " + symbol);
                }

                String normalizedSymbol = symbol.toLowerCase();

                if (symbols.contains(normalizedSymbol)) {
                    throw new DuplicateSymbolWarningException("Warning: symbol " + symbol + " already declared.");
                } else {
                    symbols.add(normalizedSymbol);
                    System.out.println("Symbol " + symbol + " added.");
                }
            }
        } catch (NonAlphanumericSymbolException | DuplicateSymbolWarningException | EmptySymbolListException e) {
            throw e; 
        }
    }
}