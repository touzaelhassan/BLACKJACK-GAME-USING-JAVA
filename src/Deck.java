import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() { this.cards = new ArrayList<>(); }

    public void deckBuilder(){

        for(Shape shape : Shape.values()){

            for(Value value : Value.values()){

                this.cards.add(new Card(shape, value));

            }

        }

    }

    public void deckMixer(){


    }

    @Override
    public String toString() {

        String cardsList ="";

        int i = 1;

        for(Card card: this.cards){
            cardsList += i + " - " + card + "\n";
            i++;
        }

        return  cardsList;
    }
}
