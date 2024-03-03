
import java.util.Random;

import java.util.Scanner;
import java.util.ArrayList;

public class Game {

    char[][] board;

    String secretWord;

    String playerGuess;

    int NumberOfErrors = 0;

    char[] letterArray = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    int STARTINDEX = 10;
    
    ArrayList<Character> listOfGuesses;

    String[] answers = { "programming", "board", "java", "computer", "coding", "developer", "algorithm",
            "debugging", "software", "microsfot", "java", "language", "machine", "learning", };

    char[] arrayPlayerInputs;

    Game() {

        listOfGuesses = new ArrayList<>();
        board = new char[10][70];

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {

                board[i][j] = '.';

            }

        }
        getSecretWord();
        printHeader();
        addPerson();
        printLetters();
        arrayPlayerInputs = new char[secretWord.length()];

    }

    private void printHeader() {
        String welcome = "Welcome to Hangman!";

        for (int i = 0, z = 22; i < welcome.length(); i++, z++) {

            board[0][z] = welcome.charAt(i);

        }
    }

    private void addPerson() {

        board[7][25] = '_';
        board[7][27] = '_';
        for (int i = 7, z = 26, c = 0; c < 5; i--, c++) {

            board[i][z] = '|';

        }

        for (int i = 0, z = 27; i < 4; i++, z++) {
            board[2][z] = '_';

        }

        board[3][30] = '|';

        board[4][30] = 'O';
        board[5][30] = '|';
        board[5][31] = '\\';
        board[5][29] = '/';
        board[6][30] = '|';
        board[7][31] = '\\';
        board[7][29] = '/';

    }

    private void printLetters() {

        String word = "Word:";

        for (int i = 0, z = 5; i <= 4; i++, z++) {

            board[4][z] = word.charAt(i);

        }

        for (int i = 0, z = STARTINDEX; i < secretWord.length(); i++, z++) {

            board[4][z] = '_';

        }

        String message = "Letters not guessed:";

        for (int i = 0, z = 42; i < message.length(); i++, z++) {
            board[5][z] = message.charAt(i);
        }

        for (int z = 45, i = 0; z < 84 && i < 13; z++, i++) {
            board[7][z] = letterArray[i];

        }
        for (int i = 45, z = 13; i < 84 && z < 26; i++, z++) {
            board[9][i] = letterArray[z];
        }
    }

    private void getSecretWord() {

        Random random = new Random();

        int num = random.nextInt(16);

        this.secretWord = this.answers[num];

        this.secretWord = this.secretWord.toUpperCase();

    }

    private boolean wordGuess() {

        return (this.secretWord.equals(this.playerGuess));

    }

    private boolean processInput() {

        listOfGuesses = new ArrayList<>();

        for (int i = 0; i < playerGuess.length(); i++) {

            for (int z = 0; z < secretWord.length(); z++) {

                if (playerGuess.charAt(i) == secretWord.charAt(z)) {

                    listOfGuesses.add(playerGuess.charAt(i)); // If guessword is bigger than the array of
                                                                // listOfGuesses

                }

            }

        }

        if (listOfGuesses.size() != 0) {
            return true;
        } else {
            removeBody();
            return false;
        }

    }

    private void removeGuessLetters() {

        for (int i = 0; i < this.playerGuess.length(); i++) {

            switch (playerGuess.charAt(i)) {

                case 'A':
                    board[7][45] = '_';
                    break;

                case 'B':
                    board[7][46] = '_';
                    break;

                case 'C':
                    board[7][47] = '_';
                    break;

                case 'D':
                    board[7][48] = '_';
                    break;
                case 'E':
                    board[7][49] = '_';
                    break;

                case 'F':
                    board[7][50] = '_';
                    break;

                case 'G':
                    board[7][51] = '_';
                    break;

                case 'H':
                    board[7][52] = '_';
                    break;
                case 'I':
                    board[7][53] = '_';
                    break;

                case 'J':
                    board[7][54] = '_';
                    break;
                case 'K':
                    board[7][55] = '_';
                    break;

                case 'L':
                    board[7][56] = '_';
                    break;

                case 'M':
                    board[7][57] = '_';
                    break;

                case 'N':
                    board[9][45] = '_';
                    break;

                case 'O':
                    board[9][46] = '_';
                    break;

                case 'P':
                    board[9][47] = '_';
                    break;

                case 'Q':
                    board[9][48] = '_';
                    break;

                case 'R':
                    board[9][49] = '_';
                    break;

                case 'S':
                    board[9][50] = '_';
                    break;

                case 'T':
                    board[9][51] = '_';
                    break;

                case 'U':
                    board[9][52] = '_';
                    break;

                case 'V':
                    board[9][53] = '_';
                    break;

                case 'W':
                    board[9][54] = '_';
                    break;

                case 'X':
                    board[9][55] = '_';
                    break;

                case 'Y':
                    board[9][56] = '_';
                    break;

                case 'Z':
                    board[9][57] = '_';
                    break;

            }

        }

    }

    private void lettersToWord() {

        for (int i = 0; i < this.listOfGuesses.size(); i++) {
            int num = 0;
            for (int z = 0; z < secretWord.length(); z++, num++) {

                if (listOfGuesses.get(i) == secretWord.charAt(z)) {
                    arrayPlayerInputs[num] = listOfGuesses.get(i);
                    board[4][num + 10] = listOfGuesses.get(i);

                }

            }

        }

    }

    private boolean charWin() {
        String str = new String(arrayPlayerInputs);

        return (str.equals(this.secretWord));
    }

    public void runGame() {

        try (Scanner input = new Scanner(System.in)) {

            while (!(isGameOver())) {
                System.out.println(this);

                System.out.print("Input guess:");

                playerGuess = input.nextLine();

                playerGuess = playerGuess.toUpperCase();

                processInput();
                removeGuessLetters();
                lettersToWord();

            }

            System.out.println(this);
            getResult();

        }

    }

    private void removeBody() {

        NumberOfErrors++;

        switch (NumberOfErrors) {

            case 1:
                board[7][29] = '.';
                break;

            case 2:
                board[7][31] = '.';
                break;

            case 3:
                board[6][30] = '.';
                break;

            case 4:
                board[5][29] = '.';
                break;

            case 5:
                board[5][31] = '.';
                break;

            case 6:
                board[5][30] = '.';
                break;
            case 7:
                board[4][30] = '.';
                break;

        }

    }

    private boolean isGameOver() {
        return (this.NumberOfErrors == 7 || wordGuess() || charWin());
    }

    private void getResult() {

        if (NumberOfErrors == 7) {
            System.out.println("You Lost!The word is:" + secretWord);
        } else if (wordGuess() == true || charWin() == true) {
            System.out.println("You Won!");
        }

    }

    public String toString() {
        String array = "";
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {

                array += board[i][j];

            }
            array += "\n";
        }
        return array;
    }

}
