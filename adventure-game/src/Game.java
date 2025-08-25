import java.util.Scanner;

public class Game {

    private boolean isGameFinished = false;
    private final Bedroom bedroom = new Bedroom("Спальня", "Просторная спальня с двуспальной кроватью");
    private final Bathroom bathroom = new Bathroom("Ванная комната", "Обычный совмещенный санузел");
    private final Kitchen kitchen = new Kitchen("Кухня", "Большая кухня с совмещенной столовой");
    // 6. В классе Game сделай новое поле rooms с массивом всех комнат (положи в него все созданные в прошлый раз комнаты).
    private final Room[] rooms = new Room[]{bedroom, bathroom, kitchen};

    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("Добро пожаловать в игру Дом, твоя цель - найти выход из дома");
        Player player = new Player();
        System.out.println("Придумайте и введите имя игрока");
        Scanner sc = new Scanner(System.in);
        player.setName(sc.next());
        System.out.println("Добро пожаловать, " + player.getName());
        System.out.println("В игре будут следующие комнаты: \n"
                + game.bedroom.getName() + " - " + game.bedroom.getDescription() + "\n"
                + game.bathroom.getName() + " - " + game.bathroom.getDescription() + "\n"
                + game.kitchen.getName() + " - " + game.kitchen.getDescription()
        );
/*
9. Теперь соединим эти методы вместе. В конце метода main сделай бесконечный цикл, в котором вызови метод showMenu и обработай его возвращаемый результат:
если пользователь ввел 0 - значит нужно выйти из игры (завершить программу). Если пользователь ввел 1, то вызови метод showRooms.
Число которое вернет метод - порядковый номер выбранной комнаты в поле rooms.
Эту выбранную комнату нужно передать в сеттер пользователю, таким образом он изменяет свою локацию.
*/
        do {
            int menuOption = game.showMenu();
            if (menuOption == 0) {
                System.out.println("Поздравляем, вы победили!");
                game.isGameFinished = true;
            } else if (menuOption == 1) {
                player.setCurrentRoom(game.rooms[game.showRooms()]);
            } else if (menuOption == 2) {
                player.showItems();
            }
        }
/*
10. Так как все это мы поместили в бесконечный цикл, то после смены комнаты пользователю будет снова показано меню с возможностью смены комнаты,
до тех пор пока он не выберет выход из игры. Но, у нас же есть поле которое означает конец игры isGameFinished, пока что мы его никак не изменяем в коде программы,
но сделаем это позже. Сейчас, просто добавь внутрь цикла самым первым действием - проверку этого поля, если оно true,
то значит игра завершена и нужно закрыть программу, вывев на консоль “Поздравляем, вы победили!”.
*/
        while (!game.isGameFinished);
    }

/*
7. Теперь сделаем самое интересное - позволим пользователю бесконечно ходить между комнатами. В классе Game сделай новый метод showMenu
который будет возвращать целое число и распечатывать пользователю список возможных действий (меню). В этом методе распечатай пользователю такое меню,
каждый пункт с новой строки: 1. Перейти в другую комнату; 0. Выход. Теперь прочитай что пользователь введет в консоли - это будет номер из меню и верни это число.
*/
    public int showMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nВыберите следующее действие:\n1. Перейти в другую комнату; \n2. Показать инвентарь;\n0. Выход.");
        return sc.nextInt();
    }

/*
8. В классе Game сделай новый метод showRooms который возвращает число и в нем распечатай пользователю список названий всех комнат (из поля rooms) с номером по порядку.
Теперь прочитай что пользователь введет в консоли - это будет порядковый номер комнаты и верни это число.
*/
     public int showRooms() {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= rooms.length; i++) {
            System.out.println(i + ". " + rooms[i - 1].getName());
        }
        int changedRoomInd = sc.nextInt() - 1;
        do {
            if (changedRoomInd >= rooms.length || changedRoomInd < 0) {
                System.out.println("Нету такой комнаты! Выберите заново!");
                changedRoomInd = sc.nextInt() - 1;
            } else {
                break;
            }
        }
        while (true);
        return changedRoomInd;
    }
}
/*
12. Обязательно проверь что все работает и все пункты меню отрабатывают корректно, закоммить изменения в текущий репозиторий и сделай пуш на github,
а в следующей теме ты закончишь этот проект и на твоем GitHub будет полноценная небольшая игра.
https://github.com/14TST12/lessons/pull/5
 */