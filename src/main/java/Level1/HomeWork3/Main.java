package Level1.HomeWork3;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        gameWords();
    }

//    1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки
//       угадать это число. При каждой попытке компьютер должен сообщить, больше ли указанное пользователем
//       число, чем загаданное, или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз?
//       1 – да / 0 – нет»(1 – повторить, 0 – нет).

    static void gameInt(){
        Random random = new Random();
        boolean winner = false;
        int a = random.nextInt(10), i, counter = 0, shot = 3;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Загадано число от 0 до 10. Отгадай его!");
        while(counter < shot){
            i = scanner.nextInt();
            if (i == a) {
                System.out.println("Верно! Это число " + a + "\nТы отгадал с " + (counter + 1) + " попытки");
                winner = true;
                break;
            }
            if (i < a) System.out.println("Загаданное число больше! У тебя осталось " + (shot-counter-1) + " попыток");
            if (i > a) System.out.println("Загаданное число меньше! У тебя осталось " + (shot-counter-1) + " попыток");
            counter++;
        }
        System.out.print("Игра окончена.");
        if (!winner) System.out.print(" Было загадано число " + a);
    }

// 2. * Создать массив из слов
//String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
// "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
// "pepper", "pineapple", "pumpkin", "potato"}.
//При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с
// загаданным словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает
// буквы, которые стоят на своих местах.
//apple – загаданное
//apricot - ответ игрока
//ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
//Для сравнения двух слов посимвольно можно пользоваться:
//String str = "apple";
//char a = str.charAt(0); - метод вернет char, который стоит в слове str на первой позиции
//Играем до тех пор, пока игрок не отгадает слово.
//Используем только маленькие буквы.

    private static void gameWords(){
        String[] words = {"apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"};
        Random random = new Random();
        String question = words[random.nextInt(words.length - 1)];
        System.out.println(question);
        String str;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            str = scanner.next();
            if (Objects.equals(question, str)) {
                System.out.println("совпало");
                break;
            }
        }
    }
}