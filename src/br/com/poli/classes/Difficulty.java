package br.com.poli.classes;

public enum Difficulty {
	
	EASY("F�cil"), NORMAL("Normal"), HARD("Dif�cil");
	
	private String description; 
	
	private Difficulty(String description){ 
		this.description = description;
	}
	

	public String getDescription() {
		return description;
	}


};
