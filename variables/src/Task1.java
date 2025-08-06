/*
2. Создай новый Java-проект с именем “variables” (можешь использовать Idea для создания проекта).
(Проект с именем “variables” в репозитории “lessons”).
 */

public class Task1 {
    public static void main(String[] args) {
        /*
        3. Создай в этом проекте новый файл с именем Task1.java, а в нем класс Task1.
        В этом классе в методе main создай 9 переменных (по одной для каждого примитивного типа данных и 1 для String)
        и сразу присвой им какое-нибудь значение.
         */
        byte byteNumber1 = 11;
        short shortNumber2 = 222;
        long longNumber3 = 3333;
        int intNumber4 = 444;
        String manyRows = "Java task #1";
        char letter = 'Q';
        double doubleNumber4 = 14632.24;
        float pi = 3.14f;
        boolean bulka = true;

        // 4. Распечатай все эти переменные в консоль, каждую с новой строки.
        System.out.println(byteNumber1);
        System.out.println(shortNumber2);
        System.out.println(longNumber3);
        System.out.println(intNumber4);
        System.out.println(manyRows);
        System.out.println(letter);
        System.out.println(doubleNumber4);
        System.out.println(pi);
        System.out.println(bulka);

        /*
        5. С каждой из числовых переменных (целочисленной и с плавающей запятой) проведи все стандартные мат.операции,
        результат каждой операции сохрани в новые переменные и выведи их в консоль
        (сложение, вычитание, умножение, деление, остаток от деления, инкремент и декремент).
         */

        // Для Байтов - литералы привёл к байту, чтобы джава не ссорилась
        byte sumByte = (byte)(byteNumber1 + 22);
        byte deltaByte = (byte)(byteNumber1 - 5);
        byte multiByte = (byte)(byteNumber1 * 3);
        byte divisionByte = (byte)(byteNumber1 / 4);
        byte remainderByte = (byte)(byteNumber1 % 4);
        // Вывожу в консольку:
        System.out.println("Результаты мат. операций для Байта: \n" + sumByte + " - это сумма, \n" + deltaByte + " - это вычитание,  \n"  + multiByte + " - это умножение, \n"
                + divisionByte + " - это деление, \n"  + remainderByte + " - это остаток от деления,");
        // Чтобы оригинальные значения не затёрлись, пишу в отдельный println
        byte incSumByte = ++sumByte;
        byte decDeltaByte = --deltaByte;
        System.out.println(incSumByte + " - это префиксный инкремент суммы, \n" + decDeltaByte + " - это префиксный декремент вычитания. \n");

        // Для Шортов - переменные объявил интами, чтобы Идея не плакала
        int sumShort = shortNumber2 + 15;
        int deltaShort = shortNumber2 - 1;
        int multiShort = shortNumber2 * 10;
        int divisionShort = shortNumber2 / 2;
        int remainderShort = shortNumber2 % 4;
        System.out.println("Результаты мат. операций для Шорта: \n" + sumShort + " - это сумма, \n" + deltaShort + " - это вычитание,  \n"  + multiShort + " - это умножение, \n"
                + divisionShort + " - это деление, \n"  + remainderShort + " - это остаток от деления,");
        // Тут ничего не произойдёт с новыми переменными, так как постфиксно меняем
        short incSumShort = (short) sumShort++;
        short decDeltaShort = (short) deltaShort--;
        System.out.println(incSumShort + " - это постфиксный инкремент суммы, \n" + decDeltaShort + " - это постфиксный декремент вычитания. \n");

        // Тут можно не приводить к никакому типу, так как Лонг имеет приоритет на Интом
        long sumLong = longNumber3 + 225;
        long deltaLong = longNumber3 - 11;
        long multiLong = longNumber3 * 39;
        long divisionLong = longNumber3 / 31;
        long remainderLong = longNumber3 % 4;
        System.out.println("Результаты мат. операций для Лонга: \n" + sumLong + " - это сумма, \n" + deltaLong + " - это вычитание,  \n"  + multiLong + " - это умножение, \n"
                + divisionLong + " - это деление, \n"  + remainderLong + " - это остаток от деления,");
        long incMultiLong = ++multiLong;
        long decDivisionLong = --divisionLong;
        System.out.println(incMultiLong + " - это префиксный инкремент умножения, \n" + decDivisionLong + " - это префиксный декремент деления. \n");

        // Для Инта приводить ни к чему не надо, так как все литералы и так инты по дефолту
        int sumInt = intNumber4 + 11;
        int deltaInt = intNumber4 - 33;
        int multiInt = intNumber4 * 15;
        int divisionInt = intNumber4 / 11;
        int remainderInt = intNumber4 % 5;
        System.out.println("Результаты мат. операций для Инта: \n" + sumInt + " - это сумма, \n" + deltaInt + " - это вычитание,  \n"  + multiInt + " - это умножение, \n"
                + divisionInt + " - это деление, \n"  + remainderInt + " - это остаток от деления,");
        int incMultiInt = ++multiInt;
        int decDivisionInt = --divisionInt;
        System.out.println(incMultiInt + " - это префиксный инкремент умножения, \n" + decDivisionInt + " - это префиксный декремент деления. \n");

        // Для Чаров - переменные объявил интами. При мат. операциях, чар преобразуется в Инт. Числовое максимальное значение чара = 2^16
        int sumChar = letter + 159;
        int deltaChar = letter - 12;
        int multiChar = letter * 13;
        int divisionChar = letter / 11;
        int remainderChar = letter % 8;
        System.out.println("Результаты мат. операций для Чара: \n" + sumChar + " - это сумма, \n" + deltaChar + " - это вычитание,  \n"  + multiChar + " - это умножение, \n"
                + divisionChar + " - это деление, \n"  + remainderChar + " - это остаток от деления,");
        long incMultiChar = multiChar++;
        long decDivisionChar = divisionChar--;
        System.out.println(incMultiChar + " - это постфиксный инкремент умножения, \n" + decDivisionChar + " - это постфиксный декремент деления. \n");

        // Тут можно не приводить к никакому типу, так как Дабл имеет приоритет на Интом. В любом случае, я использовал нецелые числа в операциях
        double sumDouble = doubleNumber4 + 2255.54;
        double deltaDouble = doubleNumber4 - 11.23;
        double multiDouble = doubleNumber4 * 65.789;
        double divisionDouble = doubleNumber4 / 31.4;
        double remainderDouble = doubleNumber4 % 25.7;
        System.out.println("Результаты мат. операций для Дабла: \n" + sumDouble + " - это сумма, \n" + deltaDouble + " - это вычитание,  \n"  + multiDouble + " - это умножение, \n"
                + divisionDouble + " - это деление, \n"  + remainderDouble + " - это остаток от деления,");
        double incSumDouble = ++sumDouble;
        double decDeltaDouble = --deltaDouble;
        System.out.println(incSumDouble + " - это префиксный инкремент суммы, \n" + decDeltaDouble + " - это префиксный декремент вычитания. \n");

        // Флоут слабее дабла, но сильнее инта. Можно юзать float тип, если при операциях с нецелыми числами юзать F/f в конце числа
        float sumFloat = pi + 656;
        float deltaFloat = pi - 1.23F;
        float multiFloat = pi * 65.789f;
        float divisionFloat = pi / 2;
        float remainderFloat = pi % 1.7F;
        System.out.println("Результаты мат. операций для Флоута: \n" + sumFloat + " - это сумма, \n" + deltaFloat + " - это вычитание,  \n"  + multiFloat + " - это умножение, \n"
                + divisionFloat + " - это деление, \n"  + remainderFloat + " - это остаток от деления,");
        float incSumFloat = sumFloat++;
        float decDeltaFloat = deltaFloat--;
        System.out.println(incSumFloat + " - это постфиксный инкремент суммы, \n" + decDeltaFloat + " - это постфиксный декремент вычитания. \n");



        // 6. Проверь что все работает корректно и загрузи этот проект в репозиторий который был создан в п.1.
        // https://github.com/14TST12?tab=repositories
    }
}
