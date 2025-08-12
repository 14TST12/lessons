import java.util.Scanner;

/*
3. В этом же проекте создай класс Task2 и в нем в методе main создай переменную в которой будет храниться количество денег
заработанных компанией за год, инициализируй ее каким-нибудь значением, а также переменную в которой будет храниться название
отрасли компании на выбор (Bank, Health или Transport) . На основании заработанной суммы будет высчитываться налог,
который нужно заплатить за эту сумму. Напиши такое условие, при котором сумма налога будет высчитываться правильно
и выводиться в консоль в таком виде: “Налог на сумму ххх для отрасли ххх составляет ххх. Это составляет ххх процентов”.
Правила по формированию налога такие:

a) Для отрасли Bank налог составляет 10% если сумма годового дохода компании составляет менее 250000$,
если доход 250000-499999 то налог составляет 15% от суммы,
если доход 500000$ и больше то налог - 18%.
b) Для отрасли Health налог составляет 7% если сумма годового дохода компании составляет менее 400000$,
если доход 400000-899999 то налог составляет 12% от суммы,
если доход 900000$ и больше то налог - 15%.
c) Для отрасли Transport налог составляет 9% если сумма годового дохода компании составляет менее 100000$,
если доход 100000-299999 то налог составляет 13% от суммы,
если доход 300000$ и больше то налог - 17%.
 */

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите заработанную компанией сумму:");
        int earnedMoney = sc.nextInt();
        String[] type = {"Bank", "Health", "Transport"};
        String chosenType = "";
        int tax = 0;
        System.out.println("Введите номер отрасли компании: \n 1 - Bank \n 2 - Health \n 3 - Transport");
        switch (sc.nextInt()) {
            case 1: // Bank
                chosenType = type[0];
                if (earnedMoney >= 0 && earnedMoney < 250000) {
                    tax = 10;
                } else if (earnedMoney >= 250000 && earnedMoney <= 499999) {
                    tax = 15;
                } else if (earnedMoney >= 500000) {
                    tax = 18;
                } else {
                    System.out.println("Вы ввели неправильную заработанную сумму. Сумма должна быть целым числом и больше нуля");
                }
                break;
            case 2: // Health
                chosenType = type[1];
                if (earnedMoney >= 0 && earnedMoney < 400000) {
                    tax = 7;
                } else if (earnedMoney >= 400000 && earnedMoney <= 899999) {
                    tax = 12;
                } else if (earnedMoney >= 900000) {
                    tax = 15;
                } else
                    System.out.println("Вы ввели неправильную заработанную сумму. Сумма должна быть целым числом и больше нуля");
                break;
            case 3: // Transport
                chosenType = type[2];
                if (earnedMoney >= 0 && earnedMoney < 100000) {
                    tax = 9;
                } else if (earnedMoney >= 100000 && earnedMoney <= 299999) {
                    tax = 13;
                } else if (earnedMoney >= 300000) {
                    tax = 17;
                } else
                    System.out.println("Вы ввели неправильную заработанную сумму. Сумма должна быть целым числом и больше нуля");
                break;
            default:
                System.out.println("Получено неправильное значение отрасли. Введённое значение должно быть целое число от 1 до 3");
        }
        if (tax != 0) {
            // if earned money and type passed validation, tax will not be 0 as it was initialized before all Ifs
            System.out.println("Налог на сумму " + earnedMoney + "$ для отрасли " + chosenType + " составляет " + earnedMoney * tax / 100 + ". Это составляет " + tax + " процентов");
            // Example: Налог на сумму 600000$ для отрасли Transport составляет 102000. Это составляет 17 процентов
        }
        sc.close();
    }
}

/* 4. Проверь что код работает корректно и загрузи проект в свой репозиторий для задач, который ты использовал(а) в прошлый раз.
Link:
https://github.com/14TST12/lessons/tree/main/branching
 */