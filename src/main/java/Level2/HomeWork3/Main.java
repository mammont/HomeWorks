package Level2.HomeWork3;

// 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных
//    слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
// 2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
//    В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать
//    номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов (в случае
//    однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
// 3. * Пройтись по списку ArrayList, например {1, 2, 3, 4, 5, 6} и удалить все четные элементы во время прохождения

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"кот", "пёс", "олень", "дятел", "бобёр", "медведь", "бобёр",
                        "орёл", "белка", "олень", "бобёр", "утка", "волк", "лиса",
                        "мышь", "олень", "петух", "черепаха", "бобёр", "медведь", "орёл"
                        };

        Set<String> set = new HashSet<>(Arrays.asList(words));
        System.out.println(set);

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        System.out.println(map);

//------------------------------------------------------------------------------------------

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+79261234567");
        phoneBook.add("Петров", "+79259876543");
        phoneBook.add("Иванов", "+79235435454");
        phoneBook.add("Иванов", "+79211111111");
        phoneBook.add("Сидоров", "+79295261726");
        phoneBook.add("Петров", "+79281780055");

        System.out.println(phoneBook.get("Иванов"));
        System.out.println(phoneBook.get("Петров"));

//------------------------------------------------------------------------------------------

        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) integers.add(i);
        System.out.println(integers);
        Iterator<Integer> integerIterator = integers.iterator();
        while (integerIterator.hasNext()) if (integerIterator.next() %2 == 0) integerIterator.remove();
        System.out.println(integers);
    }
}
