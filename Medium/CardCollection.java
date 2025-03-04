import java.util.*;
class CardCollection {
    private Map<String, List<String>> cardMap;
    public CardCollection() {
        cardMap = new HashMap<>();
    }
    public void addCard(String symbol, String cardName) {
        cardMap.putIfAbsent(symbol, new ArrayList<>());
        cardMap.get(symbol).add(cardName);
    }
    public Collection<String> getCardsBySymbol(String symbol) {
        return cardMap.getOrDefault(symbol, Collections.emptyList());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollection collection = new CardCollection();
        collection.addCard("Hearts", "Ace");
        collection.addCard("Hearts", "King");
        collection.addCard("Spades", "Queen");
        collection.addCard("Diamonds", "Jack");
        collection.addCard("Clubs", "10");
        collection.addCard("Spades", "Ace");
        System.out.print("Enter symbol to search (e.g., Hearts, Spades): ");
        String symbol = scanner.nextLine();
        Collection<String> cards = collection.getCardsBySymbol(symbol);
        if (cards.isEmpty()) {
            System.out.println("No cards found for the symbol: " + symbol);
        } else {
            System.out.println("Cards of " + symbol + ": " + cards);
        }
        scanner.close();
    }
}