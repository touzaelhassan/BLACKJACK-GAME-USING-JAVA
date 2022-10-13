public class Main {

    public static void main(String[] args) {

        System.out.println("                                     ");
        System.out.println("=====================================");
        System.out.println("|   WELCOME TO THE BLACKJACK GAME   |");
        System.out.println("=====================================");
        System.out.println("                                     ");

        Deck deck = new Deck();

        deck.deckBuilder();

        deck.deckMixer();

        System.out.println(deck);

    }

}