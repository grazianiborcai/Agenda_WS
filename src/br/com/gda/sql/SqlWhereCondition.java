package br.com.gda.sql;

public enum SqlWhereCondition {
EQUAL("="), NOT_EQUAL("<>"), LAST_INSERT_ID("LAST_INSERT_ID()");
	
	private final String symbol;
	
	
	private SqlWhereCondition(String condSymbol) {
		symbol = condSymbol;
	}
	
	
	
	public String getSymbol() {
		return symbol;
	}
}
