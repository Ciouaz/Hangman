import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("RULES\nFirst player have to type the word. Second player have to guess that word by typing letters. If the board will look like this:");
        Board board = new Board();
        board.board();
        System.out.println("you will loose.\n");


        Input put = new Input();
        String word = put.wordInput();
        word = word.toLowerCase();
        //to make console clear and hide input
        for (int i = 0; i<100; i++){
            System.out.println();
        }
        wordToGuess guess = new wordToGuess();
        BlankWord dashWord = new BlankWord();
        System.out.println("Length of the word:");
        String[] dashWordArray = dashWord.blankWord(word);
        ArrayList<String> dashWordArrayList = new ArrayList<>();
        dashWordArrayList.addAll(Arrays.asList(dashWordArray));

        while(true) {
            String letter = put.letterInput();
            letter = letter.toLowerCase();
            int guessWord = guess.guessingWord(dashWordArrayList, word, letter);
                if (guess.wordInProgress(dashWordArrayList, word, letter).replace(" ", "").equals(word.replace(" ", ""))){
                    System.out.println("Congratulation! You guess the world: " + word);
                    break;
            } else if(guessWord == 12){
                    System.out.println("You lost! The correct word was: " + word);
                    break;
                }
        }
        System.out.println("End of the game!");
    }
}