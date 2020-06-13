package beans;

public class Card {

    private int number;
    private CardType type;

    public Card(int number, CardType type) {
        this.number = number;
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public CardType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", type=" + type +
                '}';
    }
}
