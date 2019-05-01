package homework_dataTypes;

public class Main {
    public static void main(String[] args) {


        System.out.println("1.Написать программу, которая выводит в консоль числовые представления, символов Unicode: ‘D’, ‘R’, ‘f’.");

        char symb1 = 'D';
        int symbInt1 = (int) symb1;
        char symb2 = 'R';
        int symbInt2 = (int) symb2;
        char symb3 = 'f';
        int symbInt3 = (int) symb3;

        System.out.println(symb1 + " corresponds with " + symbInt1 + "\n" +
                symb2 + " corresponds with " + symbInt2 + "\n" +
                symb3 + " corresponds with " + symbInt3 + "\n" + "\n");



        System.out.println("2.Написать программу, в которой будут созданы переменные указанных типов и осуществлены соответствующие преобразования:\n" +
                "int \uF0E0 byte\n" +
                "short \uF0E0 byte\n" +
                "char \uF0E0 int\n" +
                "float \uF0E0 long\n" +
                "long \uF0E0 int\n" +
                "double \uF0E0 int\n");

        int symblInt = 258;
        byte symblByte = (byte) symblInt;
        short symblShort = 564;
        byte symblByte2 = (byte) symblShort;
        float symblFloat = 3.46f;
        long symblLong = (long) symblFloat;
        long symblLong1 = 30000000000L;
        int symblInt1 = (int) symblLong1;
        double symblDouble = 3.14;
        int symblInt2 = (int) symblDouble;

        System.out.println("int \uF0E0 byte\n" + symblInt + " corresponds with " + symblByte + "\n" +
                "short \uF0E0 byte\n" + symblShort + " corresponds with " + symblByte2 + "\n" +
                "char \uF0E0 int\n" + symb1 + " corresponds with " + symbInt1 + "\n" +
                "float \uF0E0 long\n" + symblFloat + " corresponds with " + symblLong + "\n" +
                "long \uF0E0 int\n" + symblLong1 + " corresponds with " + symblInt1 + "\n" +
                "double \uF0E0 int\n" + symblDouble + " corresponds with " + symblInt2 + "\n" + "\n");



        System.out.println("3.Написать программу, в которой осуществить упаковку int в Integer,  boolean в Boolean, char в Character, а также распаковку Float в float, Long в long. Вывести результаты на консоль.\n");

        int a = 2;
        Integer integer = a;

        boolean b = true;
        Boolean bo = b;

        char ch = 'V';
        Character cha = ch;

        Float fo = 3.14f;
        float f = fo;

        Long lo = 300000000000L;
        long l = lo;

        System.out.println("Примеры упаковки" + "\n" + "\n" +
                integer.getClass().getName() + " value: " + integer + "\n" +
                bo.getClass().getName() + " value: " + bo + "\n" +
                cha.getClass().getName() + " value: " + cha + "\n" + "\n" +
                "Примеры распаковки" + "\n" + "\n" +
                fo.getClass().getName() + " value: " + f + "\n" +
                lo.getClass().getName() + " value: " + l + "\n" + "\n");


        System.out.println("4.Написать программу, в которой при помощи методов классов String или StringBuilder произвести:\n" +
                "1)создание двух различных строк,\n" +
                "2)осуществить реверс второй строки,\n" +
                "3)получить две подстроки из каждой из начальных строк;\n" +
                "4)Вывести результат в консоль.\n");

        String str = "autobiography";
        StringBuilder stringBuilder = new StringBuilder("cat and dog");
        System.out.println("String 1:" + str + " " + "\n" +
                "String 2: " + stringBuilder + "\n" +
                "original: " + stringBuilder + "\n" +
                "reverse: " + stringBuilder.reverse() + "\n" +
                "substring 1: " + str.substring(0,4) + "\n" +
                "substring2: " + stringBuilder. reverse().substring(3,7));



    }
}
