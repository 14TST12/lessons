import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Player {
    private String name;
    private final Item[] inventory = new Item[10];
    private int nextFreeInd = 0;
    private Room currentRoom;

    public String getName() {
        return name;
    }

    public void setName() {
        Scanner sc = new Scanner(System.in);
        this.name = sc.next();
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
        System.out.println("Вы перешли в комнату " + getCurrentRoom().getName() + ".");
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void showItems() {
        if (!Arrays.stream(inventory).allMatch(Objects::isNull)) {
            for (Item item : inventory) {
                if (item != null) { // to avoid null pointer when array is not fully filled, so array item can be on any position
                    System.out.println(item.getName() + " - " + item.getDescription());
                }
            }
        } else {
            System.out.println("Инвентарь пуст!"); // to show user-friendly message if user does not have any items
        }
    }

    public void useInventory(Item item, Room room) {
        if (item instanceof Key) {
            if (((Key) item).unlockCheck(room)) {
                room.setLocked(false);
            }
        } else {
            ((Note) item).use();
        }
    }

    private boolean useItemOrNot() {
        boolean useItemOrNot = false;
        System.out.println("""
                Осмотреть какой-нибудь предмет?
                1. Да, выбрать предмет;
                2. Нет, вернуться назад.""");
        int menuOption = Game.readFromConsole(2);
        switch (menuOption) {
            case 1: {
                useItemOrNot = true;
                break;
            }
            case 2: {
                break;
            }
        }
        return useItemOrNot;
    }

    private int getItemIdToInteract() {
        System.out.println("Выберите предмет для взаимодействия:");
        return Game.readFromConsole(currentRoom.items.size()) - 1;
    }

    public void interact() {
        currentRoom.printItems();
        if (useItemOrNot()) {
            int itemId = getItemIdToInteract();
            if (itemId != 0) {
                Useful usefulItem = (Useful) currentRoom.items.get(itemId);
                if (usefulItem instanceof Collectible) {
                    System.out.println("""
                            1. Положить предмет в инвентарь
                            2. Использовать предмет
                            3. Назад"""
                    );
                    int menuOption = Game.readFromConsole(3);
                    switch (menuOption) {
                        case 1: {
                            inventory[nextFreeInd] = currentRoom.items.get(itemId);
                            ++nextFreeInd;
                            System.out.println("Предмет был добавлен в инвентарь");
                            currentRoom.items.remove(itemId);
                            // to remove the item from current room after adding it to inventory
                            break;
                        }
                        case 2: {
                            usefulItem.use();
                            break;
                        }
                        case 3: {
                            interact();
                            break;
                        }
                    }
                } else {
                    usefulItem.use();
                }
            } else {
                System.out.println("Вы выбрали несуществующую опцию!");
            }
        }
    }
}