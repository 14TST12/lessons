import java.util.Scanner;

// 1. Создай новый проект “strings”.
public class Task1 {
    /*
       2. В этом проекте создай класс Task1 и в методе main попроси пользователя через консоль ввести 5 чисел (с помощью цикла),
    добавь их все в массив, пройдись по нему в цикле for и если число четное - выведи на консоль
    “Число x - четное”, где x - это текущее число, которое мы читаем из массива. Иначе - выведи “Число x - нечетное”.
    В итоге работы программы в консоли должно быть такое же количество распечатанных строк как и кол-во элементов массива.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numArray = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.printf("Введите число #%d \n", i+1);
            numArray[i] = sc.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            if (numArray[i] % 2 == 0) {
                System.out.printf("Число %d - четное \n", numArray[i]);
            } else {
                System.out.printf("Число %d - нечетное \n", numArray[i]);
            }
        }
        sc.close();
    }
}
