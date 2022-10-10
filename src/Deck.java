import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public void createFullDeck(){
        for(Suit cardSuit : Suit.values()){

            for (Value cardValue : Value.values()){

                this.cards.add(new Card(cardSuit, cardValue));

            }

        }
    }

    public void shuffle(){

        ArrayList<Card> temporaryDeck = new ArrayList<Card>();

        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();

        for (int i = 0; i < originalSize; i++){

            randomCardIndex = random.nextInt((this.cards.size() - 1 - 0) + 1) + 0;
            temporaryDeck.add(this.cards.get(randomCardIndex));
            this.cards.remove(randomCardIndex);

        }

        this.cards = temporaryDeck;
    }

    @Override
    public String toString() {

        String cardsList = "";

        int i = 0;

        for(Card card : this.cards){
            cardsList += "\n" + i + "-" + card.toString();
            i++;
        }

        return  cardsList;

    }
}
