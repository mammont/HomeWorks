package Level1.HomeWork3;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        gameInt();
        gameWords();
    }

//    1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки
//       угадать это число. При каждой попытке компьютер должен сообщить, больше ли указанное пользователем
//       число, чем загаданное, или меньше. После победы или проигрыша выводится запрос – «Повторить игру еще раз?
//       1 – да / 0 – нет»(1 – повторить, 0 – нет).

    private static void gameInt(){
        Random random = new Random();
        boolean winner = false;
        int a = random.nextInt(10), i, t, counter = 0, shot = 3;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Загадано число от 0 до 10. Отгадай его!");
        while(counter < shot){
            i = scanner.nextInt();
            if (i < a) System.out.println("Загаданное число больше! У тебя осталось " + (shot-counter-1) + " попыток");
            else if (i > a) System.out.println("Загаданное число меньше! У тебя осталось " + (shot-counter-1) + " попыток");
            else {
                System.out.println("Верно! Это число " + a + "\nТы отгадал с " + (counter + 1) + " попытки");
                winner = true;
                break;
            }

            counter++;
        }
        System.out.print("Игра окончена.");
        if (!winner) System.out.println(" Было загадано число " + a);
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        while(true) {
            t = scanner.nextInt();
            if (t == 1) {
                gameInt();
                return;
            }
            else if (t == 0) return;
            else System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        }
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
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String question = words[random.nextInt(words.length - 1)];
        StringBuilder hint;
        int tries = 1;
        int letter;
        System.out.println("Отгадай слово!");
        while(true) {
            String str = scanner.next();
            if (Objects.equals(question, str)) {
                System.out.println("Верно! Загаданное слово - " + question + ". Ты угадал за " + tries + " попыток");
                break;
            }
            else {
                hint = new StringBuilder();
                letter = 0;
                for (int i = 0; i < question.length() && i < str.length(); i++) {
                    if (question.charAt(i) == str.charAt(i)) {
                        hint.append(question.charAt(i));
                        letter++;
                    }
                    else hint.append("#");
                }
                if (letter > 0) System.out.println("Ты угадал " + letter + " букв в слове: " + hint + "#############");
                else System.out.println("Ты не угадал ни одной буквы, попробуй ещё раз.");
            }
            tries++;
        }
        System.out.println();
    }
}