package br.com.poli.main;

import br.com.poli.classes.Difficulty;
import br.com.poli.classes.Sudoku;

public class Main {

	public static void main(String[] args) {

		Sudoku sudoku = new Sudoku("Mc Cego", Difficulty.NORMAL);
		sudoku.setValue(8, 8, 1);
		sudoku.setValue(8, 1, 3);
		sudoku.setValue(8, 2, 5);
		sudoku.setValue(2, 2, 9);
		sudoku.setValue(0, 0, 5);
		sudoku.getGridPlayer();
		
	}

}
