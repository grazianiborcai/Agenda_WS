package br.com.mind5.masterData.discountStrategy.info;

public enum Disegy {
	FIRST_TIME_PURCHASE(1);
	
	private final int codDiscountStrategy;
	
	private Disegy(int code) {
		codDiscountStrategy = code;
	}
	
	
	
	public int getCodDiscountStrategy() {
		return codDiscountStrategy;
	}
}
