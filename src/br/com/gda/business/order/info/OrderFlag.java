package br.com.gda.business.order.info;

public enum OrderFlag {
	ITEM('I'), EXTRA('E');
	
	private char flagId;
	
	private OrderFlag(char id) {
		flagId = id;
	}
	
	
	
	public char getFlagId() {
		return flagId;
	}
}
