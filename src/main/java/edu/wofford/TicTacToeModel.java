package edu.wofford;


public class TicTacToeModel {

    public enum Mark { EMPTY, XMARK, OMARK };
    public enum Result { XWIN, OWIN, TIE, NONE };
    protected Mark[][] board;
    protected boolean xTurn;

    public TicTacToeModel() {
        board = new Mark[3][3];
        for(int row = 0; row < 3; ++row){
          for(int col = 0; col < 3; ++col){
            board[row][col] = Mark.EMPTY;
          }
        }
        xTurn = true;
    }

    public boolean setMarkAt(int row, int col) {
        if(getResult() != Result.NONE){
          return false;
        }
        if(getMarkAt(row, col) == Mark.EMPTY){
          if(xTurn){
            board[row][col] = Mark.XMARK;
            xTurn = false;
          } else{
            board[row][col] = Mark.OMARK;
            xTurn = true;
          }
          return true;
        } else{
          return false;
        }
    }

    public Mark getMarkAt(int row, int col) {
        return board[row][col];
    }

    private boolean checkBoardFull() {
      boolean isBoardFull = true;
      for(int row = 0; row < 3; ++row){
        for(int col = 0; col < 3; ++col){
          if(board[row][col] == Mark.EMPTY){
            isBoardFull = false;
          }
        }
      }
      return isBoardFull;
    }

    private Result checkRowsForWin() {
      Result rowWin = Result.NONE;
      for(int i = 0; i < 3; ++i){
        if(board[i][0] != Mark.EMPTY){
          if(board[i][0] == board[i][1] && board[i][1] == board[i][2]){
            if(board[i][0] == Mark.XMARK){
              rowWin = Result.XWIN;
            } else{
              rowWin = Result.OWIN;
            }
          }
        }
      }
      return rowWin;
    }

    private Result checkColumnsForWin() {
      Result columnWin = Result.NONE;
      for(int j = 0; j < 3; ++j){
        if(board[0][j] != Mark.EMPTY){
          if(board[0][j] == board[1][j] && board[1][j] == board[2][j]){
            if(board[0][j] == Mark.XMARK){
              columnWin = Result.XWIN;
            } else{
              columnWin = Result.OWIN;
            }
          }
        }
      }
      return columnWin;
    }

    private Result checkDiagonalForWin() {
      Result diagonalWin = Result.NONE;
      if(board[0][0] != Mark.EMPTY){
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2]){
          if(board[0][0] == Mark.XMARK){
            diagonalWin = Result.XWIN;
          } else{
            diagonalWin = Result.OWIN;
          }
        }
      }
      return diagonalWin;
    }

    private Result checkReverseDiagonalForWin() {
      Result reverseDiagonalWin = Result.NONE;
      if(board[2][0] != Mark.EMPTY){
        if(board[2][0] == board[1][1] && board[1][1] == board[0][2]){
          if(board[2][0] == Mark.XMARK){
            reverseDiagonalWin = Result.XWIN;
          } else{
            reverseDiagonalWin = Result.OWIN;
          }
        }
      }
      return reverseDiagonalWin;
    }

    public Result getResult() {
      Result winner = Result.NONE;
      if(checkRowsForWin() != Result.NONE){
        winner = checkRowsForWin();
      } else if(checkColumnsForWin() != Result.NONE){
        winner = checkColumnsForWin();
      } else if(checkDiagonalForWin() != Result.NONE){
          winner = checkDiagonalForWin();
      } else if(checkReverseDiagonalForWin() != Result.NONE){
          winner = checkReverseDiagonalForWin();
      } else if(checkBoardFull()){
        winner = Result.TIE;
      } else{
        winner = Result.NONE;
      }
        return winner;
    }

    public String toString() {
        String s = "";
        String mark = "";
        for(int row = 0; row < 3; ++row){
          for(int col = 0; col < 3; ++col){
            if(board[row][col] == Mark.XMARK){
              mark = "X";
            } else if(board[row][col] == Mark.OMARK){
              mark = "O";
            } else{
              mark = " ";
            }

            if(col == 2){
              if(row == 2){
                s += String.format("%s", mark);
              } else{
                s += String.format("%s\n-----\n", mark);
              }
            } else{
              s += String.format("%s|", mark);
            }
        }
    }
    return s;
  }

}
