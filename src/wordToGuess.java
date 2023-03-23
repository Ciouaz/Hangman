import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class wordToGuess {
    Board hangman = new Board();
    String word;
    int round = 0;

    public int guessingWord(ArrayList<String> blankWord, String word, String letter){
        this.word = word;
        Pattern pattern = Pattern.compile(letter);
        Matcher matcher = pattern.matcher(word);
        if (matcher.find()){
            System.out.println("Correct letter.");
            System.out.println(wordInProgress(blankWord, word, letter).replace("", " "));
        } else {
            System.out.println("Incorrect letter.");
            System.out.println(hangman.gameBoard(round));
            round +=1;
        }
        return round;
    }

    public String wordInProgress(ArrayList<String> blankWord, String word, String letter){
        String[] progress = new String[word.length()];

        ArrayList <String> progressWordFinal = blankWord;

        for (int i = 0; i < word.length(); i++){
            progress[i] = String.valueOf(word.charAt(i));
        }
        for(int j = 0; j < word.length(); j++){
            if(progress[j].equals(letter)){
                progressWordFinal.set(j, letter);
            }
        }
        String progressWordString = String.join("", progressWordFinal);
        return progressWordString;
    }
}
