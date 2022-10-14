package br.com.mind5.masterData.common;

public enum Gender {
	DEFAULT(1),
	NOT_INFORMED(1), 
	MALE(2), 
	FEMALE(3);
	
	private int codGender;
	
	
	private Gender(int cod) {
		codGender = cod;
	}
	
	
	
	public int getCodGender() {
		return codGender;
	}
}
