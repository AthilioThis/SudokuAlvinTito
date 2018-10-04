package br.com.poli.classes;

import java.util.Calendar;
//import java.util.Random;
import java.util.Random;

public class Sudoku extends Game {

	Random random = new Random();

	private Calendar totalTime;
	private Cell[][] gridPlayer = new Cell[9][9];
	
	private int[][] gridPlayerRef = new int[9][9];
	private int[][] gridPlayerLe=new int[9][9];
	
	public Sudoku(String name, Difficulty difficulty) {
		super(name);
		initilizeSudoku(difficulty);
	}

	public void createSudoku() {
		int x = random.nextInt(1000);
		for (int i = 0; i < 3; i++, x++) {
			for (int j = 0; j < 3; j++, x += 3) {
				for (int k = 0; k < 9; k++, x++) {
					gridPlayerRef[3 * i + j][k] = (x % (9)) + 1;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				gridPlayerLe[i][j]= gridPlayerRef[i][j];
			}
		}
	}
/*	Método que pecorre e zera as celulas  de acordo com cada matriz 3X3 e recebe como parametro 
	quais coordenada deve começar a percorrer e até onde ir*/
	public void toClearCells(int iniI, int finalI, int iniJ, int finalJ, int m0, int m1) {
//		Arrays que receberão os valores das coordenadas x e y
		int [] coord1 = new int[2];
		int [] coord2 = new int[2];
		int [] coord3 = new int[2];
		int [] coord4 = new int[2];
		coord1[0]=random.nextInt(3) + m0;
		coord1[1]=random.nextInt(3) + m1;
		coord2[0]=random.nextInt(3) + m0;
		coord2[1]=random.nextInt(3) + m1;
		coord3[0]=random.nextInt(3) + m0;
		coord3[1]=random.nextInt(3) + m1;
		coord4[0]=random.nextInt(3) + m0;
		coord4[1]=random.nextInt(3) + m1;
		for(int i = iniI; i < finalI; i++) {
			for(int j = iniJ; j < finalJ; j++) {
				if(coord1[0]== i && coord1[1]==j || coord2[0]== i && coord2[1]==j || coord3[0]== i && coord3[1]==j || coord4[0]== i && coord4[1]==j) {
					
				}else {
					gridPlayerLe[i][j]= 0;
				}
					
			}
		}
	}
	
	public void  toClearNCells() {
		toClearCells(0, 3, 0, 3, 0, 0);
		toClearCells(0, 3, 3, 6, 0, 3);
		toClearCells(0, 3, 6, 9, 0, 6);
		toClearCells(3, 6, 0, 3, 3, 0);
		toClearCells(3, 6, 3, 6, 3, 3);
		toClearCells(3, 6, 6, 9, 3, 6);
		toClearCells(6, 9, 0, 3, 6, 0);
		toClearCells(6, 9, 3, 6, 6, 3);
		toClearCells(6, 9, 6, 9, 6, 6);
	}

	

	public void saveSudoku() {
		createSudoku();
		toClearNCells();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				gridPlayer[i][j] = new Cell(gridPlayerLe[i][j]);
				gridPlayer[i][j].setFixed();
			}
		}
	}

//	Método para inicializar o Sudoku de acordo com a dificuldade
	public void initilizeSudoku(Difficulty difficulty) {
//		Random r = new Random();
		if (difficulty == Difficulty.NORMAL) {
			System.out.println("Estamos jogando no modo " + Difficulty.NORMAL.getDescription() + ".\n");
			saveSudoku();
			System.out.println();

		} else if (difficulty == Difficulty.EASY) {
			System.out.println("Estamos jogando no modo " + Difficulty.EASY.getDescription() + ".\n");
		} else if (difficulty == Difficulty.HARD) {
			System.out.println("Estamos jogando no modo " + Difficulty.HARD.getDescription() + ".\n");
		} else {
			System.out.println("Opção inválida");
		}

	}

//	Método para Desenhar a grade da Matriz 9X9
	public void getGridPlayer() {
		for (int i = 0; i < 9; i++) {
			System.out.print("  |");// 2 espaços para desenhar a grade mais centralizada no console
			for (int j = 0; j < 9; j++) {
				System.out.print(gridPlayer[i][j].getValue() + "|");
				if (j == 2 || j == 5) { // dar espaço a cada matriz 3X3
					System.out.print(" |");
				}
			}
			if (i == 2 || i == 5) {// Quebrar linha para melhorar o visual e separar cada matriz 3x3
				System.out.println();
			}
			System.out.println(" ");
		}
	}
	
//	Método para Atribuir ou não valores as celulas do Sudoku de acordo com o valor inserido

	public void setValue(int x, int y, int value) { // x equivalente a linha e y equivalente a coluna
		int initial = gridPlayer[x][y].getValue();
		gridPlayer[x][y].setValue(value);
		if (!checkValidation(gridPlayer[x][y], x, y))
			gridPlayer[x][y].setValue(initial);
	}

	public boolean checkValidation(Cell cell, int x, int y) {
		int cellPosition = toKnowWhichCellIs(x, y);
		cell.setValid(cell.getValue());
		if (cell.isFixed())
			return false;
		else if (!cell.isValid())
			return false;
		else {
			for (int i = 0; i < 9; i++) {
				if (cell.getValue() == gridPlayer[x][i].getValue() && i != y) // verifica as colunas
					return false;
				else if (cell.getValue() == gridPlayer[i][y].getValue() && i != x) // verifica as linhas
					return false;
			}
			if (cellPosition == 1 || cellPosition == 2 || cellPosition == 3) {
				for (int i = 0; i < 3; i++) {
					for (int j = (cellPosition - 1) * 3; j < cellPosition * 3; j++) {
						if (cell.getValue() == gridPlayer[i][j].getValue() && i != x && j != y)
							return false;
					}
				}
			} else if (cellPosition == 4 || cellPosition == 5 || cellPosition == 6) {
				for (int i = 3; i < 6; i++) {
					for (int j = (cellPosition - 4) * 3; j < (cellPosition - 3) * 3; j++) {
						if (cell.getValue() == gridPlayer[i][j].getValue() && i != x && j != y)
							return false;
					}
				}
			} else {
				for (int i = 6; i < 9; i++) {
					for (int j = (cellPosition - 7) * 3; j < (cellPosition - 6) * 3; j++) {
						if (cell.getValue() == gridPlayer[i][j].getValue() && i != x && j != y)
							return false;
					}
				}
			}

			return true;
		}

	}

// verifica em qual matriz 3x3 vai ser colocado o novo valor
	private int toKnowWhichCellIs(int x, int y) {
		if ((x / 3) < 1) {
			if ((y / 3) < 1)
				return 1;
			else if ((y / 3) == 1)
				return 2;
			else
				return 3;
		} else if ((x / 3) > 1 && (x / 3) < 2) {
			if ((y / 3) < 1)
				return 4;
			else if ((y / 3) == 1)
				return 5;
			else
				return 6;
		} else {
			if ((y / 3) < 1)
				return 7;
			else if ((y / 3) == 1)
				return 8;
			else
				return 9;
		}
	}

//	Método para retornar o tempo total 
	public Calendar getTotalTime() {
		Calendar formatTime = Calendar.getInstance();
		formatTime.set(Calendar.HOUR_OF_DAY, super.endGame().get(Calendar.HOUR_OF_DAY) - horarioInicial[0]);
		formatTime.set(Calendar.MINUTE, super.endGame().get(Calendar.MINUTE) - horarioInicial[1]);
		formatTime.set(Calendar.SECOND, super.endGame().get(Calendar.SECOND) - horarioInicial[2]);
		return formatTime;
	}

	public Calendar endGame() {
		this.totalTime = getTotalTime();
		super.endGame();
		return totalTime;
	}
}
