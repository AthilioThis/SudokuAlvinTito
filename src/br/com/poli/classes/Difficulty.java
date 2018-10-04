package br.com.poli.classes;

public enum Difficulty {
	
	EASY("Fácil"), NORMAL("Normal"), HARD("Difícil");
	
	private String description; 
	
	private Difficulty(String description){ 
		this.description = description;
	}
	

	public String getDescription() {
		return description;
	}


};
