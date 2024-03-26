/**
 * This class represents items in the game.
 */
public class Item {
    private String name;
    private double weight;

    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name;
    }
}
