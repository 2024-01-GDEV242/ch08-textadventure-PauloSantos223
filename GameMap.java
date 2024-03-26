import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the map of the game.
 */
public class GameMap {
    private List<Room> rooms;

    public GameMap() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }
}

