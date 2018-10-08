package edu.wofford;

import java.util.Scanner;

public class ConsoleMain {

	// x always starts first
	// 9 total plays
	// if invalid move - rejected - remains current player's xTurn

	// game starts - board is made / class instantiated X
	// first play goes to X
	// After X - O goes
	// X->O->X->O... until getRestult() = TIE or OWIN or XWIN -> while getResult() is NONE

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int row, col;

		TicTacToeModel game = new TicTacToeModel();

		while(game.getResult() == TicTacToeModel.Result.NONE) {
			// get row
			// do{
      //     while(!keyboard.hasNextInt()){
      //           System.out.println("Not a valid row, try again");
      //           keyboard.next();
      //     }
      //     row = keyboard.nextInt();
      //   } while (row < 0 || row > 2);
			// // get col
			// do{
      //     while(!keyboard.hasNextInt()){
      //           System.out.println("Not a valid col, try again");
      //           keyboard.next();
      //     }
      //     col = keyboard.nextInt();
      //   } while (col < 0 || col > 2);

			row = keyboard.nextInt();
			col = keyboard.nextInt();

				if(game.setMarkAt(row, col) == false) {
					System.out.println("placement not availabe, try again.");
				} else {
					game.setMarkAt(row, col);
					game.toString();
				}
			}
		}


}
