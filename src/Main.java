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

            boolean endRound = false;

            System.out.println("============ YOUR MONEY BAG ===========");
            System.out.println("|                                     |");
            System.out.println("|                 $" + playerMoney +"                |");
            System.out.println("|                                     |");
            System.out.println("=======================================");
            System.out.println("                                       ");
            System.out.print("HOW MUCH MONEY WOULD YOU LIKE TO BET : ");
            int playerBet = scanner.nextInt();
            System.out.println("                                     ");

            if(playerBet > playerMoney){
                System.out.print("YOU CAN NOT BET MORE THAN WHAT YOU HAVE");
                System.out.println("                                            ");
                break;
            }

            // DISTRIBUTING CARDS
              playerDeck.distributeCard(mainDeck);
              playerDeck.distributeCard(mainDeck);

              dealerDeck.distributeCard(mainDeck);
              dealerDeck.distributeCard(mainDeck);

              while(true){

                  System.out.println("YOUR HAND :");
                  System.out.println("-----------");
                  System.out.println("           ");
                  System.out.println(playerDeck);
                  System.out.println("YOUR HAND IS VALUED AT : " + playerDeck.cardsValue());
                  System.out.println("                  ");

                  System.out.println("THE DEALER HAND :");
                  System.out.println("-----------------");
                  System.out.println("                 ");
                  System.out.println("1 - " + dealerDeck.getCard(0));
                  System.out.println("2 - [ HIDDEN CARD ]");
                  System.out.println("                  ");

                  System.out.println("=====================================");
                  System.out.println("                        ");
                  System.out.println("[1] - GET NEW CARD      ");
                  System.out.println("[2] - STOP              ");
                  System.out.println("                        ");

                  System.out.print("ENTER YOUR CHOICE : ");
                  int choice = scanner.nextInt();
                  System.out.println("                  ");

                  if(choice == 1){

                      playerDeck.distributeCard(mainDeck);
                      System.out.println("YOUR NEW CARD IS : " + playerDeck.getCard(playerDeck.deckSize() - 1).toString());

                      if(playerDeck.cardsValue() > 21){
                          System.out.println("YOUR HAND IS VALUED AT : " + playerDeck.cardsValue());
                          System.out.println("OOPS !!! THE DEALER BEATS YOU");
                          System.out.println("                         ");
                          playerMoney -= playerBet;
                          endRound = true;
                          break;
                      }
                  }

                  if(choice == 2){
                      break;
                  }

              }

            // REVEAL DEALER CARDS
              System.out.println("DEALER CARDS :");
              System.out.println("--------------");
              System.out.println(dealerDeck);
              System.out.println("              ");

              System.out.println("*******************************");
              System.out.println("*******************************");
              System.out.println("*******************************");

              System.out.println("DEALER HAND : " + dealerDeck.cardsValue());
              System.out.println("PLAYER HAND : " + playerDeck.cardsValue());

            playerDeck.moveAllToDeck(mainDeck);
            dealerDeck.moveAllToDeck(mainDeck);

        }

        System.out.println("                                      ");
        System.out.println("=======================================");
        System.out.println("| GAME OVER !! - YOU ARE OUT OF MONEY |");
        System.out.println("=======================================");
        System.out.println("                                      ");

    }

}