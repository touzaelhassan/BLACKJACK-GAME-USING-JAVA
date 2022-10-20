public class Card {

    private Shape shape;
    private Value value;

    public Card(Shape shape, Value value) {
        this.shape = shape;
        this.value = value;
    }

    public void setShape(Shape shape) { this.shape = shape; }
    public void setValue(Value value) { this.value = value; }
    public Shape getShape() { return shape; }
    public Value getValue() { return value; }

    @Override
    public String toString() {
        return "Card{" +
                "shape=" + shape +
                ", value=" + value +
                '}';
    }
}
