package Level1.Homework4;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        start();
    }
    static void start() {
        int dimension = 3;
        char[][] field = emptyField(dimension);
        drawField(field);

        while (true) {
            doPlayerMove(field);
            drawField(field);
            if (isWin(field, 'X')) {
                System.out.println("Congrats!!! You are winner!");
                break;
            }
            if (isDraw(field)) {
                System.out.println("That's draw. Game is finished");
                break;
            }

            doAIMove(field);
            drawField(field);
            if (isWin(field, 'O')) {
                System.out.println("Sorry!!! You are looser!");
                break;
            }
            if (isDraw(field)) {
                System.out.println("That's draw. Game is finished");
                break;
            }
        }
    }

    static boolean isDraw(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (isFreeCell(field, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isWin(char[][] field, char symbol) {
//        if (field.length > 4) checkBigFields(field, symbol);
        return checkDiagonals(field, symbol) || checkLines(field, symbol);
    }

    static boolean checkBigFields (char[][] field, char symbol) {

        return false;
    }

    static boolean checkDiagonals(char[][] field, char symbol) {
        boolean main = true, second = true;
        for (int i = 0; i < field.length; i++) {
                main = main & (field[i][i] == symbol);
                second = second & (field[field.length - i - 1][i] == symbol);
        }
        return main || second;
    }

    static boolean checkLines(char[][] field, char symbol){
        boolean horizontal, vertical;
        for (int i = 0; i < field.length; i++) {
            horizontal = true;
            vertical = true;
            for (int j = 0; j < field.length; j++) {
                horizontal = horizontal & (field[i][j] == symbol);
                vertical = vertical & (field[j][i] == symbol);
            }
            if (horizontal || vertical) return true;
        }
        return false;
    }

    static void doPlayerMove(char[][] field) {
        int h, v;

        do {
            h = getCoordinate(field.length, 'h');
            v = getCoordinate(field.length, 'v');
        } while (isOccupiedCell(field, h, v));

        field[h][v] = 'X';
    }

    static int getCoordinate(int length, char symbol) {
        Scanner scanner = new Scanner(System.in);
        int coordinate;

        do {
            System.out.printf("Please input %s-value ...%n", symbol);
            coordinate = scanner.nextInt() - 1;
        } while (coordinate < 0 || coordinate >= length);

        return coordinate;
    }

    static void doAIMove(char[][] field) {
        Random random = new Random();
        int h, v;

        do {
            h = random.nextInt(field.length);
            v = random.nextInt(field.length);
        } while (isOccupiedCell(field, h, v));

        field[h][v] = 'O';
    }

    static boolean isFreeCell(char[][] field, int h, int v) {
        return !isOccupiedCell(field, h, v);
    }

    static boolean isOccupiedCell(char[][] field, int h, int v) {
        return field[h][v] != '-';
    }

    static char[][] emptyField(int dimension) {
        char[][] field = new char[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                field[i][j] = '-';
            }
        }
        return field;
    }

    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}