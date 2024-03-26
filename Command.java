import java.util.Arrays;

/**
 * This class handles user commands.
 */
public class Command {
    private static final String[] MOVEMENT_COMMANDS = {"go", "move", "north", "south", "east", "west"};

    /**
     * Executes the given command.
     * @param command The command to execute.
     * @param player The player object to manipulate based on the command.
     * @throws IllegalArgumentException if the command is invalid.
     */
    public void execute(String command, Player player) throws IllegalArgumentException {
        String[] tokens = command.toLowerCase().split(" ");
        if (Arrays.asList(MOVEMENT_COMMANDS).contains(tokens[0])) {
            if (tokens.length == 1) {
                throw new IllegalArgumentException("Specify a direction to move.");
            }
            String direction = tokens[1];
            switch (direction) {
                case "north":
                    player.moveNorth();
                    break;
                case "south":
                    player.moveSouth();
                    break;
                case "east":
                    player.moveEast();
                    break;
                case "west":
                    player.moveWest();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid direction.");
            }
        } else {
            switch (tokens[0]) {
                case "look":
                    System.out.println("You look around the room.");
                    break;
                case "inventory":
                    System.out.println("Inventory: " + player.getInventory());
                    break;
                case "help":
                    displayAvailableCommands();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid command.");
            }
        }
    }

    /**
     * Displays all available commands to the user.
     */
    private void displayAvailableCommands() {
        System.out.println("Available commands:");
        for (String cmd : MOVEMENT_COMMANDS) {
            System.out.println(cmd);
        }
        System.out.println("look");
        System.out.println("inventory");
        System.out.println("help");
    }
}

