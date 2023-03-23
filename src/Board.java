import java.util.Arrays;
import java.util.List;

public class Board {
    String[] board = {" ", "_", "_", "_\n", " ", "|", "/", "o\n", " ", "|", " ", "X\n",
            " ", "|", " ", " \n", "—", "—", "—", " "};
    String[] emptyBoard = {" ", " ", " ", " \n", " ", " ", " ", " \n", " ", " ", " ", " \n",
            " ", " ", " ", " \n", " ", " ", " ", " "};
    Integer[] nextRound = {18, 17, 16, 13, 9, 5, 1, 2, 3, 6, 7, 11};
    List gameBoard = Arrays.asList(emptyBoard);

    String[][] replacements = {{"[", " "}, {"]", " "}, {",", ""}};

    public String board() {

        String boardRep = replacements(board);
        System.out.println(boardRep);
        return boardRep;
    }

    public String gameBoard(int round){

        for(int i = 0; i<=round; i++){
            gameBoard.set(nextRound[i], board[nextRound[i]]);
        }
        String gameBoardRep = String.valueOf(gameBoard);
        gameBoardRep = replacements(gameBoardRep);
        return gameBoardRep;
    }

    public String replacements(String[] toReplace){
        String replaced = Arrays.deepToString(toReplace);
        for (String[] replacement : replacements) {
            replaced = replaced.replace(replacement[0], replacement[1]);
        }
        return replaced;
    }

    public String replacements(String toReplace){
        for (String[] replacement : replacements) {
            toReplace = toReplace.replace(replacement[0], replacement[1]);
        }
        return toReplace;
    }
}
