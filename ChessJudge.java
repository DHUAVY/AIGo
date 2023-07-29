public class ChessJudge implements GoData{

    // 检查水平方向是否有五子连珠
    private static boolean judgeRow(int x, int y, int player){
        int numChess = 1;
        for(int i = y - 1; i > -1; i--){
            if(chessArr[x][i] == player){
                numChess ++;
                if(numChess == 5) return true;
            }
            else break;
        }
        for(int i = y + 1; i < COLS; i++){
            if(chessArr[x][i] == player){
                numChess ++;
                if(numChess == 5) return true;
            }
            else break;
        }
        return false;
    }

    // 检查竖直方向是否有五子连珠
    private static boolean judgeCol(int x, int y, int player){
        int numChess = 1;
        for(int i = x - 1; i > -1; i--){
            if(chessArr[i][y] == player){
                numChess ++;
                if(numChess == 5) return true;
            }
            else break;
        }
        for(int i = x + 1; i < ROWS; i++){
            if(chessArr[i][y] == player){
                numChess ++;
                if(numChess == 5) return true;
            }
            else break;
        }
        return false;
    }

    // 检查右下斜方向是否有五子连珠
    private static boolean judgeRightDown(int x, int y, int player){
        int numChess = 1;
        for(int i = x - 1, j = y - 1; i > -1 && j > -1; i--, j--){
            if(chessArr[i][j] == player){
                numChess ++;
                if(numChess == 5) return true;
            }
            else break;
        }
        for(int i = x + 1, j = y + 1; i < ROWS && j < COLS; i++, j++){
            if(chessArr[i][j] == player){
                numChess ++;
                if(numChess == 5) return true;
            }
            else break;
        }
        return false;
    }

    // 检查右上斜方向是否有五子连珠
    private static boolean judgeRightUp(int x, int y, int player){
        int numChess = 1;
        for(int i = x - 1, j = y + 1; i > -1 && j < COLS; i--, j++){
            if(chessArr[i][j] == player){
                numChess ++;
                if(numChess == 5) return true;
            }
            else break;
        }
        for(int i = x + 1, j = y - 1; i < COLS && j > -1; i++, j--){
            if(chessArr[i][j] == player){
                numChess ++;
                if(numChess == 5) return true;
            }
            else break;
        }
        return false;
    }

    public static boolean checkWin(int x, int y, int player) {
        return judgeRow(x, y, player) || judgeCol(x, y, player) || judgeRightDown(x, y, player) || judgeRightUp(x, y, player);
    }
}
