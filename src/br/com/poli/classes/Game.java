package br.com.poli.classes;

import java.util.Calendar;
import br.com.poli.classes.Player;

public class Game {

	private Calendar startTime;
	private Calendar endTime;
	private Difficulty difficulty;
	protected int[] horarioInicial = new int[3];

	public Game(String name) {
		startGame(name);

	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

//	Método para Atribuir um jogador e Salvar ao horário de inicio do jogo
	public int[] startGame(String name) {
		Player player = new Player(name);
		System.out.println("Bem-vindo ao Sudoku " + player.getName() + "!");
		int[] formatTime = new int[3];
		startTime = Calendar.getInstance();
		int initialHour = startTime.get(Calendar.HOUR_OF_DAY);
		int initialMinute = startTime.get(Calendar.MINUTE);
		int initialSecond = startTime.get(Calendar.SECOND);
		formatTime[0] = initialHour;
		formatTime[1] = initialMinute;
		formatTime[2] = initialSecond;
		return formatTime = this.horarioInicial;

	}

//	Método para capturar e retornar o horário do termino do jogo
	public Calendar endGame() {

		this.endTime = Calendar.getInstance();
		endTime.get(Calendar.HOUR_OF_DAY);
		endTime.get(Calendar.MINUTE);
		endTime.get(Calendar.SECOND);

		return endTime;
	}

}