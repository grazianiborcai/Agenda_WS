package br.com.gda.business.order.info;

public enum OrderFlag {
	HEADER('H'), EXTRA('E');
	
	private char flagId;
	
	private OrderFlag(char id) {
		flagId = id;
	}
	
	
	
	public char getId() {
		return flagId;
	}
}
