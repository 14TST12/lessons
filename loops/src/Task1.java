import java.util.Random;

// 1. Создай новый проект “loops”.
public class Task1 {
    // 2. В этом проекте создай класс Task1
    public static void main(String[] args) {
// и в методе main cоздай массив строк и положи в него имена: John, Bob, Mary, Peter, Sarah (или любые другие).
        String[] fullNamesList = {
                // < 4 letters (33 names)
                "Mia", "Ava", "Zoe", "Leo", "Eli", "Ben", "Max", "Ivy", "Kai", "Eva",
                "Sam", "Roy", "Tim", "Jay", "Joy", "Ann", "Sue", "Kim", "Dan", "Tom",
                "Liz", "Lee", "Pam", "Amy", "Ray", "Ian", "Ana", "Hal", "Ned", "Joe",
                "Gil", "Lou", "Tad",
                // 4 letters (33 names)
                "Noah", "Emma", "Owen", "Ella", "Luke", "John", "Anna", "Ryan", "Jack", "Will",
                "Kyle", "Maya", "Sara", "Liam", "Amos", "Cora", "Iris", "Dean", "Erik", "Jane",
                "Gabe", "Cody", "Levi", "Mila", "Leia", "Cole", "Saul", "Adam", "Lisa", "Abel",
                "Troy", "Jude", "Gwen",
                // > 4 letters (34 names)
                "Olivia", "William", "Charlotte", "Alexander", "Isabella", "Benjamin", "Evelyn", "Theodore", "Harper", "Penelope",
                "Sebastian", "Eleanor", "Christopher", "Gabriella", "Samantha", "Jonathan", "Catherine", "Nicholas", "Elizabeth", "Victoria",
                "Jennifer", "Zachary", "Madeleine", "Michelle", "Stephanie", "Dominic", "Matthew", "Caroline", "Christian", "Rebecca",
                "Brandon", "Kennedy", "Savannah", "Kimberly"
        };
        // Generated an array with 100 names to choose some of them later

        int randomArrayLength = new Random().nextInt(6) + 4; // generates random size of array (from 4 to 10) that will be used next
        System.out.println("Результат проверки через цикл For:");
        forCycle(arrayRandomizer(fullNamesList, randomArrayLength));
        System.out.println();

        randomArrayLength = new Random().nextInt(6) + 4;
        System.out.println("Результат проверки через цикл Foreach:");
        foreachCycle(arrayRandomizer(fullNamesList, randomArrayLength));
        System.out.println();

        randomArrayLength = new Random().nextInt(6) + 4;
        System.out.println("Результат проверки через цикл While:");
        whileCycle(arrayRandomizer(fullNamesList, randomArrayLength));
        System.out.println();

        randomArrayLength = new Random().nextInt(6) + 4;
        System.out.println("Результат проверки через цикл Do-While:");
        doWhileCycle(arrayRandomizer(fullNamesList, randomArrayLength));
        System.out.println();
    }

    // This method will take defined number of random names from the list of 100 names and return String array with chosen names
    public static String[] arrayRandomizer(String[] fullNamesList, int newArraySize) {
        String[] chosenArray = new String[newArraySize];
        System.out.print("Массив имён: ");
        /*
         I know that method doing/returning smth except specific value in return clause is NOT a good practice (at least in C-based languages),
         and it should be done in Main() method
         but this is the easiest way how to print name array as the cycle already written and used here.
         Can be re-written if needed
         */
        for (int i = 0; i < newArraySize; i++) {
            int randomIndex = new Random().nextInt(fullNamesList.length);
            chosenArray[i] = fullNamesList[randomIndex];
            System.out.print(chosenArray[i] + " ");
        }
        System.out.println();
        return chosenArray;
    }

    /*
Пройдись в цикле for по этому массиву, и если:
a) длина(кол-во букв) элемента массива текущей итерации меньше 4, то напечатай в консоль “Ваше имя короче 4 букв”,
b) длина(кол-во букв) элемента массива текущей итерации больше 4, то напечатай в консоль “Ваше имя длиннее 4 букв”,
c) в остальных случаях напечатай “Ваше имя состоит из 4 букв”.
     */
    public static void forCycle(String[] names) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() < 4) {
                System.out.println("Ваше имя короче 4 букв");
            } else if (names[i].length() > 4) {
                System.out.println("Ваше имя длиннее 4 букв");
            } else {
                System.out.println("Ваше имя состоит из 4 букв");
            }
        }


    }

    // Comment from me: obviously the sub-task about Foreach loop missing here:
    public static void foreachCycle(String[] names) {
        for (String n : names) {
            if (n.length() < 4) {
                System.out.println("Ваше имя короче 4 букв");
            } else if (n.length() > 4) {
                System.out.println("Ваше имя длиннее 4 букв");
            } else {
                System.out.println("Ваше имя состоит из 4 букв");
            }
        }
    }

    /*
    Теперь сделай то же самое, но с помощью циклов while и do-while.
    В итоге у тебя должно быть 3 разных цикла которые итерируют один и тот же массив,
    и результат работы каждого цикла - одинаковый.
    while:
     */
    public static void whileCycle(String[] names) {
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
    }

    // do while:
    public static void doWhileCycle(String[] names) {
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
Результаты прогона можно посмотреть в файле Execution.txt
 */