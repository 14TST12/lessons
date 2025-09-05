import java.util.*;

public class Game {

    private final Room[] rooms = new Room[]{
            new Bedroom("Первая спальня", "Просторная спальня с двуспальной кроватью", false), //0
            new Bedroom("Вторая спальня", "Просторная спальня с детской кроватью", true), //1
            new Bedroom("Третья спальня", "Просторная спальня с двуспальной кроватью", true), //2
            new Bathroom("Основная ванная комната", "Основной совмещенный санузел", false), //3
            new Bathroom("Маленькая ванная комната", "Запасной совмещенный санузел", true), //4
            new Kitchen("Кухня", "Большая кухня с совмещенной столовой", false), //5
            new Lobby("Коридор", "Большой коридор соединящий все комнаты") //6
            // length = 7
    };

    private final Room lobbyRoom = rooms[rooms.length - 1];
    private static boolean isGameFinished = false;

    private static void setIsGameFinished() {
        isGameFinished = true;
    }

    public static void main(String[] args) {
        Game game = new Game();
        Player player = new Player();
        System.out.println("""
                Добро пожаловать в игру Дом, твоя цель - найти выход из дома
                Придумайте и введите имя игрока:""");
        player.setName();
        System.out.println("Добро пожаловать, " + player.getName() + "\nВ игре будут следующие комнаты:\n");
        for (Room room : game.rooms) {
            System.out.println(room.getName() + " - " + room.getDescription());
        }
        game.generateRoomsContent(game, player);
        useMenu(game, player);
    }

    private void generateRoomsContent(Game game, Player player) {
        // setting Lobby as a starting point
        player.setCurrentRoom(game.lobbyRoom);
        // generating room index where ancient key will be generated (except Lobby and Kitchen)
        int ancientKeyRoomInd = new Random().nextInt(0, 3);
        // adding a path: "kitchen - bathroom2 -> room with ancient key"
        game.rooms[5].items.add(new Key("Ключ", "Обычный ключ из комнаты: " + game.rooms[5].getName(), game.rooms[4]));
        game.rooms[4].items.add(new Key("Ключ", "Обычный ключ из комнаты: " + game.rooms[4].getName(), game.rooms[ancientKeyRoomInd]));
        game.rooms[ancientKeyRoomInd].items.add(new Key("Ключ", "Старинный ключ", game.lobbyRoom)); // adding Ancient Key to random room
        // Generating Notes with hints for each room. 1  note for 1  room
        List<String> noteMessages = new ArrayList<>();
        noteMessages.add("Выход находится в коридоре");
        noteMessages.add("Ключ поможет выйти. Используй его из инвентаря");
        noteMessages.add("Ключ из " + game.rooms[5].getName() + " поможет открыть " + game.rooms[4].getName());
        noteMessages.add("Ключ из " + game.rooms[4].getName() + " поможет открыть " + game.rooms[ancientKeyRoomInd].getName());
        // shuffle notes in array to add specific note each time to different rooms
        Collections.shuffle(noteMessages);
        for (int i = 0; i < game.rooms.length-3; i++) {
            // game.rooms.length-1 -> There is a main Note in Lobby generated directly in Lobby class
            if(i!=ancientKeyRoomInd) {
                game.rooms[i].items.add(new Note("Заметка","Заметка из комнаты " + game.rooms[i].getName(),noteMessages.get(i)));
            }
        }
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
                            System.out.println("""
                                    Комната закрыта! Попробовать открыть?
                                    1. Да. Открыть инвентарь
                                    0. Нет. Вернуться назад""");
                            menuOption = readFromConsole(1);
                            switch (menuOption) {
                                case 1: {
                                    player.unlockRoom(chosenRoom);
                                    if(!chosenRoom.isLocked()) {
                                        player.setCurrentRoom(chosenRoom);
                                    }
                                }
                                case 0: {
                                    break;
                                }
                            }

                        } else {
                            player.setCurrentRoom(chosenRoom);
                        }
                    } else {
                        System.out.print("Возвращаемся обратно. ");
                        player.setCurrentRoom(game.lobbyRoom);
                    }
                    break;
                case 2:
                    player.showInventoryItems();
                    player.useInventory(player.getCurrentRoom());
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

    private int showRoomsAndChoose() {
        for (int i = 1; i < rooms.length; i++) { // to hide Lobby
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