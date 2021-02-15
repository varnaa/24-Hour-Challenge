package Easy;

/**
 * @author swethavarnaa
 */
public class WinnerOnTicTacToe {

    public String tictactoe(int[][] moves) {

        int length = moves.length;
        int[] count = new int[8];

        for (int i = length - 1; i >= 0; i -= 2) {
            int row = moves[i][0];
            int col = moves[i][1];

            count[row]++;
            count[col + 3]++;

            if (row == col) {
                count[6]++;
            }

            if (row + col == 2) {
                count[7]++;
            }

            if (count[row] == 3 || count[col + 3] == 3 || count[6] == 3 || count[7] == 3) {
                return length % 2 == 0 ? "B" : "A";
            }
        }

        if (length < 9) {
            return "Pending";
        }

        return "Draw";
    }


}
