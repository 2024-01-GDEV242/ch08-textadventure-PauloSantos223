import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class represents the Randomness game.
 * It allows the game to be run outside of BlueJ.
 * Author: Paulo Santos
 * Version: 1.0
 */
public class Game {
    private static final int TIME_LIMIT_SECONDS = 600; // 10 minutes of game time limit

    private GameMap map;
    private Player player;
    private Command commandHandler;
    private Timer timer;
    private int elapsedTimeSeconds;

    public Game() {
        map = new GameMap();
        commandHandler = new Command();
        initializeMap(); // Method to initialize the game map with rooms and items
        startTimer();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }

    public void play() {
        // Game loop
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            // Display current room information
            System.out.println("You are in room " + player.getCurrentRoom().getDescription());
            System.out.println("Items in the room: " + player.getCurrentRoom().getItems());

            // Get user input (command)
            System.out.print("Enter command: ");
            String userInput = scanner.nextLine();

            // Execute command
            try {
                commandHandler.execute(userInput, player);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            // Check game over condition (For example, player reaches a specific room)
            if (player.getCurrentRoom().getDescription().equals("Exit")) {
                gameOver = true;
            }

            // Check time limit
            if (elapsedTimeSeconds >= TIME_LIMIT_SECONDS) {
                System.out.println("Time's up! Game over.");
                gameOver = true;
            }
        }

        // Stop the timer
        stopTimer();

        // Game over, perform any final actions
        System.out.println("Congratulations, you have reached the exit!");
    }

    private void initializeMap() {
    // Create rooms
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");
        Room room3 = new Room("Room 3");
        Room room4 = new Room("Room 4");
        Room room5 = new Room("Room 5");
        Room room6 = new Room("Room 6");
        Room room7 = new Room("Room 7");
        Room room8 = new Room("Room 8");
        Room room9 = new Room("Room 9");
        Room room10 = new Room("Room 10");
        Room room11 = new Room("Room 11");
        Room room12 = new Room("Room 12");
        Room room13 = new Room("Room 13");
        Room room14 = new Room("Room 14");
        Room room15 = new Room("Room 15");

    // Set room connections
        room1.setNorthRoom(room2);
        room2.setSouthRoom(room1);
        room2.setEastRoom(room3);
        room3.setWestRoom(room2);
        room3.setNorthRoom(room4);
        room4.setSouthRoom(room3);
        room4.setEastRoom(room5);
        room5.setWestRoom(room4);
        room5.setNorthRoom(room6);
        room6.setSouthRoom(room5);
        room6.setEastRoom(room7);
        room7.setWestRoom(room6);
        room7.setNorthRoom(room8);
        room8.setSouthRoom(room7);
        room8.setEastRoom(room9);
        room9.setWestRoom(room8);
        room9.setNorthRoom(room10);
        room10.setSouthRoom(room9);
        room10.setEastRoom(room11);
        room11.setWestRoom(room10);
        room11.setNorthRoom(room12);
        room12.setSouthRoom(room11);
        room12.setEastRoom(room13);
        room13.setWestRoom(room12);
        room13.setNorthRoom(room14);
        room14.setSouthRoom(room13);
        room14.setEastRoom(room15);
        room15.setWestRoom(room14);

    // Add rooms to map
        map.addRoom(room1);
        map.addRoom(room2);
        map.addRoom(room3);
        map.addRoom(room4);
        map.addRoom(room5);
        map.addRoom(room6);
        map.addRoom(room7);
        map.addRoom(room8);
        map.addRoom(room9);
        map.addRoom(room10);
        map.addRoom(room11);
        map.addRoom(room12);
        map.addRoom(room13);
        map.addRoom(room14);
        map.addRoom(room15);
        
    // Add items to rooms
    Item item1 = new Item("Sword", 5.0);
        room1.addItem(item1);

    Item item2 = new Item("Rubber Duck", 1.0);
        room2.addItem(item2);
        
    Item item3 = new Item("Bubble Gum", 5.0);
        room3.addItem(item3);
        
    Item item4 = new Item("Pencil", 1.5);
        room4.addItem(item4);
        
    Item item5 = new Item("Lava Pool", 10.0);
        room5.addItem(item5);
        
    Item item6 = new Item("Water Pool", 1.0);
        room6.addItem(item6); 
        
    Item item7 = new Item("Air", 0.5);
        room7.addItem(item7); 
        
    Item item8 = new Item("Sulfur", 4.0);
        room8.addItem(item8); 
        
    Item item9 = new Item("Chair", 2.0);
        room9.addItem(item9); 
        
    Item item10 = new Item("Knife", 10.0);
        room10.addItem(item10); 
        
    Item item11 = new Item("Teddy Bear", 1.0);
        room11.addItem(item11);
        
    Item item12 = new Item("Horse", 50.0);
        room12.addItem(item12);
        
    Item item13 = new Item("Shovel", 5.0);
        room13.addItem(item13);
        
    Item item14 = new Item("Spoon", 1.0);
        room14.addItem(item14);
        
    Item item15 = new Item("Parachute", 10.0);
        room15.addItem(item15);
    
    // Set player's starting room
        player = new Player(room1); // Passes the starting room to the Player constructor
    }

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                elapsedTimeSeconds++;
            }
        }, 1000, 1000); // Update elapsed time every second
    }

    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }
}


