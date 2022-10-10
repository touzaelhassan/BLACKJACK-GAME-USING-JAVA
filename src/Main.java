public class Main {

    public static void main(String[] args) {

        System.out.println("=============================");
        System.out.println("| WELCOME TO BLACKJACK GAME |");
        System.out.println("=============================");

        Deck playingDeck = new Deck();

        playingDeck.createFullDeck();
        System.out.println(playingDeck.toString());

        System.out.println("*********************************");

        playingDeck.shuffle();
        System.out.println(playingDeck.toString());

    }

}