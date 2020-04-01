package br.com.mind5.common;

public final class TotAmount {
	private static final int DEFAULT_DEC_PLACE = 2;

	private int decimalPlace;
	
	
	public TotAmount() {
		this(DEFAULT_DEC_PLACE);
	}
	
	
	
	public TotAmount(int decPlace) {
		checkArgument(decPlace);
		decimalPlace = decPlace;
	}
	
	
	
	public double computeTotal(double amountOne, double amountTwo) {
		long operOne = toLong(amountOne, decimalPlace);
		long operTwo = toLong(amountTwo, decimalPlace);
		
		return (operOne + operTwo) / Math.pow(10, decimalPlace);
	}
	
	
	
	public double computeTotalItem(double amountOne, int quantity) {
		long operOne = toLong(amountOne, decimalPlace);
		long operTwo = quantity;
		
		return (operOne * operTwo) / Math.pow(10, decimalPlace);
	}
	
	
	
	private long toLong(double amount, int decPlace) {
		return (long) (amount * (Math.pow(10, decPlace)));
	}
	
	
	
	private void checkArgument(int decPlace) {
		if (decPlace <= 0) {
			logException(new IllegalArgumentException(SystemMessage.POSITIVE_NUM_EXPECTED));
			throw new IllegalArgumentException(SystemMessage.POSITIVE_NUM_EXPECTED);
		}
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}
}
