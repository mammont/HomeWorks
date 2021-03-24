package Level1.HomeWork6;

import Level1.HomeWork6.Animals.Cat;
import Level1.HomeWork6.Animals.Dog;

//1. Создать классы Собака и Кот с наследованием от класса Животное.
//2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
// Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
//3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
//4. * Добавить подсчет созданных котов, собак и животных.
public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Мурзик", 200, 0);

        Dog dog = new Dog ("Бобик", 500, 10);

        cat.run(300);
        cat.swim(200);
        dog.run(400);
        dog.swim(12);
        System.out.println(cat.toString());
        System.out.println(dog.toString());

    }
}
