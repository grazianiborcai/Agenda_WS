package br.com.mind5.masterData.language.info;

public enum Langu {
	ENGLISH("EN"),
	DEFAULT("EN"),
	PORTUGUESE_BR("PT");
	
	
	private final String codLanguage;
	
	
	private Langu(String cod) {			
		codLanguage = cod;
	}
	
	
	
	public String getCod() {
		return codLanguage;
	}
}
