package example;

/**
 * Created by sharanya.p on 9/26/2017.
 */
public class NCrossNGame {

    private char[][] board;

    public static void main(String args[]) {
        NCrossNGame nCrossNGame = new NCrossNGame();
        nCrossNGame.board = new char[5][5];
        nCrossNGame.board[2][2] = 'W';
        nCrossNGame.board[2][3] = 'W';
        nCrossNGame.board[3][1] = 'W';
        nCrossNGame.board[3][2] = 'B';
        nCrossNGame.board[3][3] = 'B';
        nCrossNGame.board[3][4] = 'W';
        nCrossNGame.board[4][2] = 'W';
        nCrossNGame.board[4][3] = 'W';
        nCrossNGame.solve(3, 2);
    }

    private String solve(int x, int y) {
        char val = board[x][y];
        char oppVal = opp(val);
        if (evaluate(board[x][y - 1]) && board[x][y + 1] == oppVal && board[x - 1][y] == oppVal && board[x + 1][y] == oppVal) {
            return "trapped";
        }


        return "escaped";
    }

    private boolean evaluate(char i) {
        if (i == opp(i) || i == 0)
            return true;
        return false;
    }

    private char opp(char input) {
        if (input == 'W')
            return 'B';
        else
            return 'W';
    }

}
