package br.com.gda.business.cart.info;

public enum CartFlag {
	ITEM('I'), FEE('F'), TOTAL('T'), ALL('A'), NON_ITEM('N');
	
	private char flagId;
	
	private CartFlag(char id) {
		flagId = id;
	}
	
	
	
	public char getFlagId() {
		return flagId;
	}
}
