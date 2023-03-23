import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Input {
    ArrayList<String> usedLetters = new ArrayList<>();
    public String input() throws IOException {
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        String character = reader.readLine();
        return character;
    }

    public String wordInput() throws IOException {
        System.out.println("First player, type world to guess by your opponent:");
        String letter = input();
        return letter;
    }

    public String letterInput() throws IOException {
        System.out.println("Type letter to solve word:");
        String letter = input();
        letter = letter.toLowerCase();

        while (letter.length() != 1) {
            System.out.println("You should type only one letter!");
            letter =  input();
            letter = letter.toLowerCase();
        }
        int j = 0;
        while(j != 2) {
            for (int i = 0; i < usedLetters.size(); i++) {
                if (letter.equals(usedLetters.get(i))) {
                    j = 0;
                    System.out.println("You used that letter. Type another.");
                    letter = input();
                    while (letter.length() != 1) {
                        System.out.println("You should type only one letter!");
                        letter = input();
                    }
                }
            }
            j++;
        }
        usedLetters.add(letter);
        return letter;
    }


}
