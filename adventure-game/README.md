# Adventure Game (Escape the House)

A text-based adventure game written in Java.  
The player must explore rooms, find items and hints, and escape from the house.  
The main goal is to find the **ancient key** and use it to unlock the exit in the lobby.

---
## Project Structure
- **src/**
    - Core game classes:
        - `Game` - main class, entry point (`Main()`).
        - `Player` - the player.
        - `Bedroom`, `Bathroom`, `Kitchen`, `Lobby` - rooms inside the house, realization of parent class `Room`.
        - `Key`, `Note`, `Furniture`, `Window` - game items, realization of parent clas `Item`.
        - `Useful`,`Collectible` - interfaces that define item's behavior.
- **out/** — compiled classes and build artifacts.
- **adventure-game.jar** — runnable JAR file.

---
## How to Run
### 1. Using the JAR file
The compiled artifact `adventure-game.jar` is located in the project.  
Run it with:
```bash
java -jar out/artifacts/adventure_game_jar/adventure-game.jar
```
### 2. Run from IDE Console
Run the application directly from IDE by running Main() method in Game.java class

---
## Gameplay
1. On start, enter your player name.  
2. You begin in the Lobby (corridor).  
3. Explore rooms, read notes, and collect keys.  
4. Some rooms are locked. Use keys from your inventory to unlock them.  
5. The ancient key is placed at random and ultimately lets you finish the game in the Lobby.

---
## The game provides a menu with options:
1. Move to another room / return to the lobby.  
2. Show inventory and use items.  
3. Show all items in the current room.  
4. Show the current room information.  
5. Remind the player’s name.  
6. Change the player’s name.  
0. Exit the game.
---