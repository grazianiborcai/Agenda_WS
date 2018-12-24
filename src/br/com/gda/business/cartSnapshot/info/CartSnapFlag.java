package br.com.gda.business.cartSnapshot.info;

public enum CartSnapFlag {
	ITEM('I'), NON_ITEM('N');
	
	private char flagId;
	
	private CartSnapFlag(char id) {
		flagId = id;
	}
	
	
	
	public char getFlagId() {
		return flagId;
	}
}
