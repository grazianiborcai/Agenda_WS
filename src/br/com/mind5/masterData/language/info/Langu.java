package br.com.mind5.masterData.language.info;

public enum Langu {
	ENGLISH("EN");
	
	
	private final String codLanguage;
	
	
	private Langu(String cod) {
		codLanguage = cod;
	}
	
	
	
	public String getCod() {
		return codLanguage;
	}
}
