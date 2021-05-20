package Level3.HomeWork1;

import Level3.HomeWork1.Fruits.Apple;
import Level3.HomeWork1.Fruits.Orange;
import java.util.ArrayList;
import java.util.Arrays;

/*
1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;
3. Большая задача:
a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну
   коробку нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можете использовать ArrayList;
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
   (вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут
   в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем
   сравнивать с коробками с апельсинами);
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку
   фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается,
   а в другую перекидываются объекты, которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.
 */
public class Main {
    public static void main(String[] args) {
        Integer array1[] = {0,1,2,3,4,5,6,7,8,9,10,11};
        String array2[] = {"A", "B", "C", "D", "E"};
        swap(array1,1,6);
        swap(array2,0,2);
        asList(array2);

        BoxWithFruits<Apple> appleBox = new BoxWithFruits<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        System.out.println(appleBox.getWeight());
        BoxWithFruits<Orange> orangeBox = new BoxWithFruits<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        BoxWithFruits<Orange> anotherOrangeBox = new BoxWithFruits<>();
        anotherOrangeBox.add(new Orange());
        orangeBox.transfer(anotherOrangeBox);
        System.out.println(orangeBox.getWeight());
        System.out.println(anotherOrangeBox.getWeight());
    }


    public static void swap(Object[] array, int a, int b){
        System.out.println(Arrays.toString(array));
        if (a > array.length - 1 | b > array.length - 1) {
            System.out.println("Неверные аргументы");
        }
        else {
            Object object = array[a];
            array[a] = array[b];
            array[b] = object;
        }
        System.out.println(Arrays.toString(array));
    }

    public static <T> void asList(T[]arr){
        ArrayList<T> tArrayList = new ArrayList<>(Arrays.asList(arr));
        System.out.println(tArrayList);
    }
}
