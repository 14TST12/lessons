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

    public void unlockRoom(Room chosenRoom) {
        showInventoryItems();
        useInventory(chosenRoom);
    }

    public void showInventoryItems() {
        if (!Arrays.stream(inventory).allMatch(Objects::isNull)) {
            System.out.println("В инвентаре находятся следующие вещи:");
            for (int i = 0; i < inventory.length - 1; i++) {
                if (inventory[i] != null) { // to avoid null pointer when array is not fully filled, so array item can be on any position
                    System.out.println(i + 1 + ". " + inventory[i].getName() + " - " + inventory[i].getDescription());
                }
            }
        } else {
            System.out.println("Инвентарь пуст!"); // to show user-friendly message if user does not have any items
        }
    }

    public void useInventory(Room room) {
        if (!Arrays.stream(inventory).allMatch(Objects::isNull) && useItemOrNot()) {
            int itemId = getItemIdToInteract(inventory.length);
            if (inventory[itemId] instanceof Key) {
                ((Key) inventory[itemId]).useKeyToUnlock(room);
            } else {
                ((Note) inventory[itemId]).use();
            }
        }
    }

    public boolean useItemOrNot() {
        boolean useItemOrNot = false;
        System.out.println("""
                Выбрать какой-нибудь предмет для использования?
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

    private int getItemIdToInteract(int length) {
        System.out.println("Выберите предмет для взаимодействия:");
        return Game.readFromConsole(length) - 1;
    }

    public void interact() {
        currentRoom.printItems();
        if (useItemOrNot()) {
            int itemId = getItemIdToInteract(currentRoom.items.size());
            if (itemId >= 0) {
                Useful usefulItem = (Useful) currentRoom.items.get(itemId);
                if (usefulItem instanceof Collectible) {
                    System.out.println("""
                            1. Положить предмет в инвентарь
                            2. Использовать предмет
                            0. Назад"""
                    );
                    int menuOption = Game.readFromConsole(2);
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
                            if (usefulItem instanceof Note) {
                                usefulItem.use();
                            } else {
                                System.out.println("Ничего не произошло"); // Key instances must be used near locked doors
                            }
                            break;
                        }
                        case 0: {
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