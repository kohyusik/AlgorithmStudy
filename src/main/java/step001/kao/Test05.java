package step001.kao;


public class Test05 {


    public static void main(String[] args) {


        String[] input1 =
                {"CCBDE",
                 "AAADE",
                 "AAABF",
                 "CCBBF"};
        printBoard(createBoard(4, 5, input1));
        System.out.println();System.out.println();

        String[] input2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        printBoard(createBoard(6, 6, input2));
    }

    public static char[][] createBoard(int height, int width, String[] inputTable) {

        char[][] board = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = inputTable[i].charAt(j);
            }
        }

        return board;
    }

    public static void printBoard(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}