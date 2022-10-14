package br.com.mind5.masterData.common;

public enum Environ {
	PRODUCTIVE("PRODUCTIVE"), 
	SANDBOX("SANDBOX");
	
	private final String codEnviron;
	
	
	private Environ(String cod) {
		codEnviron = cod;
	}


	public String getCodEnviron() {
		return codEnviron;
	}
}
