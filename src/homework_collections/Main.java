package homework_collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //колличество одинаковых элементов в 2-х коллекциях
        int identicalElements = 10_000;
        //размер коллекций
        int sizeCollection = 100_000;

        List<Egar> list1 = new ArrayList<>(sizeCollection);
        List<Egar> list2 = new ArrayList<>(sizeCollection);



        //заполнение коллекций одинаковыми элементами
        Egar egar;
        for (int i = 0; i < identicalElements; i++) {
            egar = randomObjectEgar();
            list1.add(egar);
            list2.add(egar);
        }

        //заоплнение коллекций случайными элементами
        for (int i = identicalElements; i < 100_000; i++) {
            list1.add(randomObjectEgar());
            list2.add(randomObjectEgar());
        }

        // для чистоты эксперемента перемешаем коллекции
        Collections.shuffle(list1);
        Collections.shuffle(list2);

        // начальное время
        long start = System.currentTimeMillis();

        List<Egar> duplicateList = new ArrayList<>(findDuplicates(list1, list2));

        //время окончания
        long finish = System.currentTimeMillis();

        //финальное время обработки
        long timeConsumedMillis = finish - start;

        System.out.println("Время работы findDuplicates: " + timeConsumedMillis + "милисекунд");
        System.out.println("Количество дубликатов в коллекциях: " + duplicateList.size());

    }

    /**
     *
     * @param str
     * @param length
     * @return случайно заполненную строку
     */
    private static String generateString(String str, int length) {

        Random random = new Random();
        char[] text;
        text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = str.charAt(random.nextInt(str.length()));
        }
        return new String(text);
    }

    /**
     * Метод возвращает случайно заполненный объект Egar
     * @return объект Egar
     */
    private static Egar randomObjectEgar() {

        Egar egar = new Egar();

        egar.setName(generateString("abcdefghijklmnopqrstuvwxyz", 10));
        egar.setPhone("+37529" + generateString("0123456789", 7));
        egar.setSize(Integer.parseInt(generateString("666", 3)));

        return egar;
    }



    private static List<Egar> findDuplicates(Collection<Egar> arr1, Collection<Egar> arr2) {

        Set<Egar> set1 = new HashSet<>(arr1);
        Set<Egar> set2 = new HashSet<>(arr2);

//        List<Egar> list = new ArrayList<>(arr1);
//        List<Egar> lis3 = new ArrayList<>(arr2);

        //начало выполнения
        long start = System.currentTimeMillis();

        // находим пересечение коллекций

        //поиск пересечений при использовании ArrayList намного больше(2785 милисекунд)
        // и целесообразнее использовать коллекцию типа HashSet
        // list.retainAll(lis3);

        set1.retainAll(set2);


        //окончание выполнения
        long finish = System.currentTimeMillis();

        //финальное время обработки
        long timeConsumedMillis = finish - start;

        System.out.println("Время retainAll:" + timeConsumedMillis + " милисекунд");

        return new ArrayList<>(set1);
    }




}


