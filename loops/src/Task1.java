// 1. Создай новый проект “loops”.
public class Task1 {
    // 2. В этом проекте создай класс Task1
    public static void main(String[] args) {
// и в методе main cоздай массив строк и положи в него имена: John, Bob, Mary, Peter, Sarah (или любые другие).
        String[] names = {"John", "Bob", "Mary", "Peter", "Sarah" };
        /*
Пройдись в цикле for по этому массиву, и если:
a) длина(кол-во букв) элемента массива текущей итерации меньше 4, то напечатай в консоль “Ваше имя короче 4 букв”,
b) длина(кол-во букв) элемента массива текущей итерации больше 4, то напечатай в консоль “Ваше имя длиннее 4 букв”,
c) в остальных случаях напечатай “Ваше имя состоит из 4 букв”.
         */
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() < 4) {
                System.out.println("Ваше имя короче 4 букв");
            } else if (names[i].length() > 4) {
                System.out.println("Ваше имя длиннее 4 букв");
            } else {
                System.out.println("Ваше имя состоит из 4 букв");
            }
        }
        // Комментарий от меня: тут явно пропущена подзадача на foreach
        for (String n : names) {
            if (n.length() < 4) {
                System.out.println("Ваше имя короче 4 букв");
            } else if (n.length() > 4) {
                System.out.println("Ваше имя длиннее 4 букв");
            } else {
                System.out.println("Ваше имя состоит из 4 букв");
            }
        }
        /*
        Теперь сделай то же самое, но с помощью циклов while и do-while.
        В итоге у тебя должно быть 3 разных цикла которые итерируют один и тот же массив,
        и результат работы каждого цикла - одинаковый.
        while:
         */
        int w = 0;
        while (w < names.length) {
            if (names[w].length() < 4) {
                System.out.println("Ваше имя короче 4 букв");
            } else if (names[w].length() > 4) {
                System.out.println("Ваше имя длиннее 4 букв");
            } else {
                System.out.println("Ваше имя состоит из 4 букв");
            }
            w++;
        }
        // do while:
        int d = 0;
        do {
            if (names[d].length() < 4) {
                System.out.println("Ваше имя короче 4 букв");
            } else if (names[d].length() > 4) {
                System.out.println("Ваше имя длиннее 4 букв");
            } else {
                System.out.println("Ваше имя состоит из 4 букв");
            }
            d++;
        }
        while (d < names.length);
    }
}
/*
3. Убедись что все работает правильно и загрузи проект в свой публичный репозиторий для задач.
https://github.com/14TST12/lessons/tree/main/loops
 */