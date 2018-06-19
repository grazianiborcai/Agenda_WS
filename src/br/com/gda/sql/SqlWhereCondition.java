package br.com.gda.sql;

public enum SqlWhereCondition {
EQUAL("="), NOT_EQUAL("<>"), GREATER_OR_EQUAL(">="), LESS_OR_EQUAL("<=");
	
	private final String symbol;
	
	
	private SqlWhereCondition(String condSymbol) {
		symbol = condSymbol;
	}
	
	
	
	public String getSymbol() {
		return symbol;
	}
}
