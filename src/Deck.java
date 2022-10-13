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

        ArrayList<Card> mixedDeck = new ArrayList<>();
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();

        for (int i = 0; i < originalSize; i++){
            randomCardIndex = random.nextInt((this.cards.size() - 1 - 0) + 1) + 0;
            mixedDeck.add(this.cards.get(randomCardIndex));
            this.cards.remove(randomCardIndex);
        }

        this.cards = mixedDeck;

    }

    public void distributeCard(Deck mainDeck){

        this.cards.add(mainDeck.getCard(0));
        mainDeck.removeCard(0);

    }

    public Card getCard(int index){ return this.cards.get(index); }

    public void removeCard(int index){ this.cards.remove(index); }

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
