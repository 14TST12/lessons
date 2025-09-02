import java.util.Random;
import java.util.Scanner;

public class Game {
    /*
bedroom1	bedroom2	bedroom3
	|			|			|
	o			l			l
	|			|			|
-------------------------------
              lobby           --AC--> exit
-------------------------------
	|			|			|
	o			l			o
	|			|			|
bathroom1	bathroom2	kitchen
     */
    private final Room[] rooms = new Room[]{
            new Bedroom("Первая спальня", "Просторная спальня с двуспальной кроватью", false),
            new Bedroom("Вторая спальня", "Просторная спальня с детской кроватью", true),
            new Bedroom("Третья спальня", "Просторная спальня с двуспальной кроватью", true),
            new Bathroom("Основная ванная комната", "Основной совмещенный санузел", false),
            new Bathroom("Маленькая ванная комната", "Запасной совмещенный санузел", true),
            new Kitchen("Кухня", "Большая кухня с совмещенной столовой", false),
            new Lobby("Коридор", "Большой коридор соединящий все комнаты")
    };

    public Room[] getRooms() {
        return rooms;
    }

    private final Room lobbyRoom = rooms[rooms.length - 1];
    private static boolean isGameFinished = false;

    private static void setIsGameFinished() {
        isGameFinished = true;
    }

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Добро пожаловать в игру Дом, твоя цель - найти выход из дома");
        Player player = new Player();
        System.out.println("Придумайте и введите имя игрока");
        player.setName();
        System.out.println("Добро пожаловать, " + player.getName());
        System.out.println("В игре будут следующие комнаты: \n");
        for (Room room : game.rooms) {
            System.out.println(room.getName() + " - " + room.getDescription());
        }
        // setting Lobby as a starting point
        player.setCurrentRoom(game.lobbyRoom);
        // generating room index where ancient key will be generated
        int ancientKeyRoomInd = new Random().nextInt(0, game.rooms.length - 2);
        // adding keys to all rooms:
        for (int i = 0; i < game.rooms.length; i++) {
            if (i == ancientKeyRoomInd) {
                game.rooms[ancientKeyRoomInd].items.add(new Key("Ключ", "Старинный ключ", game.lobbyRoom)); // adding Ancient Key to random room
            } else {
                game.rooms[i].items.add(new Key("Ключ", "Обычный ключ из комнаты: " + game.rooms[i].getName())); // adding 'false' keys to other rooms
            }
        }
        useMenu(game, player);
    }

    private static void useMenu(Game game, Player player) {
        do {
            int menuOption = game.showMenu();
            switch (menuOption) {
                case 0:
                    System.out.println("Вы ушли из игры!");
                    setIsGameFinished();
                    break;
                case 1:
                    // We can move to other rooms only from lobby. From other rooms we can only return to lobby
                    if (player.getCurrentRoom() == game.lobbyRoom) {
                        Room chosenRoom = game.rooms[game.showRoomsAndChoose()];
                        if (chosenRoom.isLocked()) {
                            System.out.println("Комната закрыта! Поробовать открыть?\n" +
                                    "1. Да. Открыть инвентарь\n" +
                                    "2. Нет. Вернуться назад");
                            Scanner sc = new Scanner(System.in);
                            sc.nextInt();
                        } else {
                            player.setCurrentRoom(chosenRoom);
                        }
                    } else {
                        System.out.print("Возвращаемся обратно. ");
                        player.setCurrentRoom(game.lobbyRoom);
                    }
                    break;
                case 2:
                    player.showItems();
                    break;
                case 3:
                    player.interact();
                    break;
                case 4:
                    System.out.println("Текущая комната: "
                            + player.getCurrentRoom().getName() + " - "
                            + player.getCurrentRoom().getDescription());
                    break;
                case 5:
                    System.out.println(player.getName());
                    break;
                case 6:
                    System.out.println("Придумайте и введите имя игрока заново");
                    player.setName();
                    System.out.println("Ну здравствуй, " + player.getName());
                    break;
                default:
                    System.out.println("Выберите актуальную опцию меню!!!");
                    break;
            }
        }
        while (!isGameFinished);
    }

    private int showMenu() {
        System.out.println("""
                \nВыберите следующее действие:
                1. Перейти в другую комнату;
                2. Показать инвентарь;
                3. Показать все предметы в комнате;
                4. В какой я комнате сейчас?
                5. Напомни, а как меня зовут?
                6. Я хочу поменять свою имя
                0. Выход.""");
        return readFromConsole(6);
    }

    public int showRoomsAndChoose() {
        for (int i = 1; i <= rooms.length; i++) {
            System.out.println(i + ". " + rooms[i - 1].getName());
        }
        return readFromConsole(rooms.length) - 1;
    }

    public static void winningTheGame() {
        System.out.println("Это тот самый ключ и он использован в нужной комнате! \n " +
                "Поздравляем, игра завершена!");
        setIsGameFinished();
    }

    public static int readFromConsole(int menuOptionLimit) {
        Scanner sc = new Scanner(System.in);
        int chosenOption;
        do {
            if (sc.hasNextInt()) {
                chosenOption = sc.nextInt();
                if (chosenOption >= 0 && chosenOption <= menuOptionLimit) {
                    break;
                } else {
                    System.out.println("Ошибка: Выберите опцию от 0 до " + menuOptionLimit + "!");
                }
            } else {
                System.out.println("Ошибка: Вы должны ввести число!");
                sc.next();
            }
        }
        while (true);
        return chosenOption;
    }
}