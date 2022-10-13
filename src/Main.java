import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("                                     ");
        System.out.println("=======================================");
        System.out.println("|    WELCOME TO THE BLACKJACK GAME    |");
        System.out.println("=======================================");
        System.out.println("                                       ");

        Deck mainDeck = new Deck();
        mainDeck.deckBuilder();
        mainDeck.deckMixer();

        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();
        Scanner scanner = new Scanner(System.in);
        int playerMoney = 500;

        // THE GAME LOOP

        while(playerMoney > 0){

            System.out.println("===================================");
            System.out.println("|          YOUR MONEY BAG         |");
            System.out.println("|               $" + playerMoney +"              |");
            System.out.println("===================================");
            System.out.println("                                   ");
            System.out.print("HOW MUCH MONEY WOULD YOU LIKE TO BET : ");
            int playerBet = scanner.nextInt();
            System.out.println("                                     ");

            if(playerBet > playerMoney){
                System.out.print("SORRY YOU CAN NOT BET MORE THAN WHAT YOU HAVE.");
                System.out.println("                                            ");
                break;
            }

            boolean endRound = false;

            // DISTRIBUTING CARDS
              playerDeck.distributeCard(mainDeck);
              playerDeck.distributeCard(mainDeck);

              dealerDeck.distributeCard(mainDeck);
              dealerDeck.distributeCard(mainDeck);

            playerMoney -= playerBet;

        }

        System.out.println(playerDeck);
        System.out.println(dealerDeck);

        System.out.println("                                      ");
        System.out.println("=======================================");
        System.out.println("| GAME OVER !! - YOU ARE OUT OF MONEY |");
        System.out.println("=======================================");
        System.out.println("                                      ");

    }

}