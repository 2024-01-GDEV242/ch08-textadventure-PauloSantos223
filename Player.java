import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the player in the game.
 */
public class Player {
    private Room currentRoom;
    private List<Item> inventory;

    public Player(Room startingRoom) {
        currentRoom = startingRoom;
        inventory = new ArrayList<>();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public void moveNorth() {
        // currentRoom = currentRoom.getNorthRoom();
        System.out.println("You move north.");
    }

    public void moveSouth() {
        // currentRoom = currentRoom.getSouthRoom();
        System.out.println("You move south.");
    }

    public void moveEast() {
        currentRoom = currentRoom.getEastRoom();
        System.out.println("You move east into Room 2.");
    }

    public void moveWest() {
        // currentRoom = currentRoom.getWestRoom();
        System.out.println("You move west.");
    }
}

