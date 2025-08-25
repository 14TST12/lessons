import java.util.Arrays;
import java.util.Objects;

public class Player {
    private String name;
    private Item[] inventory = new Item[10];
    /*
    2. Сделай в классе Player новое поле currentRoom с типом Room, которое будет хранить ссылку на конкретную комнату
    в которой прямо сейчас находится игрок (ванная, спальня или кухня).
    */
    Room currentRoom = new Room();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
        5. В классе Player сделай сеттер для поля currentRoom, в котором помимо стандартного присвоения параметра к полю,
        выведи в консоль: “Вы перешли в комнату %Название комнаты%”.
        */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
        System.out.println("Вы перешли в комнату " + this.currentRoom.getName() + ".");
    }

    /*
    11. Добавь в класс Player новый метод showItems, который просто распечатывает в консоль названия всех предметов в инвентаре пользователя.
    А в классе Game добавь дополнительным пунктом под номером 2 в главное меню пункт - Показать инвентарь, и соответственно там, где ты проверяешь
    что выбрал пользователь в меню, нужно вызвать у игрока метод showItems, если метод showMenu вернул цифру 2.
    */
    public void showItems() {
        if (!Arrays.stream(inventory).allMatch(Objects::isNull)) {
            for (Item item : inventory) {
                System.out.print(item.getName() + " ");
                System.out.println();
            }
        } else {
            System.out.println("Инвентарь пуст!");
        }
    }
}