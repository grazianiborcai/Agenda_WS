package br.com.gda.business.masterData.info.common;

public enum Environ {
	PRODUCTIVE("PRODUCTIVE"), SANDBOX("SANDBOX");
	
	private final String codEnviron;
	
	
	private Environ(String cod) {
		codEnviron = cod;
	}


	public String getCodEnviron() {
		return codEnviron;
	}
}
