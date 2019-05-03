public class Grid {
     private int[][] myBoard=new int [6][7];
     private int lastSign=0;
     private int numOfTurn=0;
     private boolean gameOver=false;

     //creation of empty board 7x6
    public Grid() {
        for(int i=0;i<6;i++) {
            for(int j=0;j<7;j++) myBoard[i][j] = 0;
        }
    }

    //giocata
    public  String played(int pos,int sign){
        while(!gameOver) {
            if (sign != 1 && sign != 5) return "VALUE NOT CORRECT";
            if (pos < 0 || pos > 7) return "POSITION NOT CORRECT";
            if (numOfTurn == 0) {
                lastSign = sign;
                return "TURN" + numOfTurn++ + ":SIGN INSERTED" + lastSign + "PAWN AT:" + pos + "COLUMN";
            }
            if (lastSign == sign) return "ATTENTION,NOT YOUR TURN!";
            for (int i = 5; i > 0; i--) {
                if (myBoard[i][pos] == 0) {
                    myBoard[i][pos] = sign;
                    System.out.println(myBoard[i][pos]);
                    lastSign = sign;
                    numOfTurn++;
                    if (youWin()) return "PLAYER" + lastSign + "WIN.\n GAMEOVER ☺";
                    return "TURN" + numOfTurn + ": SIGN INSERTED" + lastSign + "PAWN AT:" + pos + "COLUMN";
                }
            }
            if (numOfTurn == 21) return "PAIR.GAMEOVER ☺";
        }
        return "GAME OVER!";

    }

    //vittoria
    public boolean youWin() {
            int sumRow = 0;
            int sumCol = 0;
            int sumPrincipalDiagonal1 = 0;
            int sumPrincipalDiagonal2 = 0;
            int sumSecondaryDiagonal1 = 0;
            int sumSecondaryDiagonal2 = 0;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    sumRow = myBoard[i][j] + myBoard[i][j + 1] + myBoard[i][j + 2] + myBoard[i][j + 3];
                }
                if (sumRow == 4 || sumCol == 20) return true;
            }
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    sumCol = myBoard[0 + j][i] + myBoard[1 + j][i] + myBoard[2 + j][i] + myBoard[3 + j][i];
                }
                if (sumRow == 4 || sumCol == 20) return true;
            }
            //Principal and Secondary Diagonal
            for (int i = 2; i >= 0; i--) {
                int maxShift = 2 - i;
                for (int j = 0; j < maxShift; j++) {
                    sumPrincipalDiagonal1 = myBoard[i + j][j] + myBoard[i + 1 + j][1 + j] + myBoard[i + 2 + j][j + 2] + myBoard[i + 3 + j][j + 3];
                    sumSecondaryDiagonal1 = myBoard[j][i + j] + myBoard[j + 1][i + 1 + j] + myBoard[j + 2][i + 2 + j] + myBoard[j + 3][i + 3 + j];
                }
                if (sumPrincipalDiagonal1 == 4 || sumPrincipalDiagonal1 == 20 || sumSecondaryDiagonal1 == 4 || sumSecondaryDiagonal1 == 20)
                    return true;
            }
            for (int i = 0; i < 3; i++) {
                int maxShift = 3 + i;
                int shift = 0;
                for (int j = 6; j > maxShift; j--) {
                    sumSecondaryDiagonal2 = myBoard[i + shift][j] + myBoard[i + 1 + shift][j - 1] + myBoard[i + 2 + shift][j - 1] + myBoard[i + 3 + shift][j - 3];
                    ++shift;
                }
                if (sumSecondaryDiagonal2 == 4 || sumSecondaryDiagonal2 == 20) return true;
            }

            for (int j = 1; j < 4; j++) {
                int maxShift = 4 - j;
                for (int i = 0; i < maxShift; i++) {
                    int shift = 0;
                    sumPrincipalDiagonal2 = myBoard[i][j + shift] + myBoard[i + 1][j + 1 + shift] + myBoard[i + 2][j + 2 + shift] + myBoard[i + 3][j + 3 + shift];
                    ++shift;
                }
                if (sumPrincipalDiagonal2 == 4 || sumPrincipalDiagonal2 == 20) return true;
            }
        return false;

    }



    public String toString() {
        StringBuilder printBoard= new StringBuilder();
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                printBoard.append("| ").append(myBoard[i][j]).append(" |");
            }
            printBoard.append("\n");
        }
        return printBoard.toString();
    }

}


