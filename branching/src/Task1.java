/*1. Создай новый проект “branching” в своем репозитории для задач.

2. В этом проекте создай класс Task1 и в нем в методе main cоздай числовую переменную и присвой ей результат от 1 до 100 (пускай это будет результат экзамена).
Напиши такое условие, что если переменная в пределах 1..25 то в консоль выводит надпись “Плохо”, если от 26 до 50,
то в консоль выводит надпись “Ниже среднего”, от 51 до 75 то “Выше среднего” и от 76 до 100 - “Отлично”. Если переменная меньше 1 или больше 100 то должно выводиться “Ошибка”.
 */

public class Task1 {
    public static void main(String[] args) {
        int examResult = (int)(0.01 + (Math.random()*100));
        System.out.println(examResult);
        if (examResult >= 1 && examResult <=25) {
            System.out.println("Плохо");
        }
        else if (examResult >= 26 && examResult <= 50) {
            System.out.println("Ниже среднего");
        }
        else if (examResult >= 51 && examResult <= 75) {
            System.out.println("Выше среднего");
        }
        else if (examResult >= 76 && examResult <= 100) {
            System.out.println("Отлично");
        }
        else System.out.println("Ошибка");
    }
}
