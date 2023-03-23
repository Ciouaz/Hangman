import java.util.Arrays;

public class BlankWord {
    public String[] blankWord(String word){
        String[] blankWord = new String[word.length()];
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++){
            blankWord[i]= "_";
        }
        String blankWordString = Arrays.toString(blankWord);
        blankWordString=blankWordString.replace(",","").replace("[","").replace("]","");
        System.out.println(blankWordString);
        return blankWord;
    }
}
