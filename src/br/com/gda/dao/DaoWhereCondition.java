package br.com.gda.dao;

public enum DaoWhereCondition {
EQUAL("="), 
NOT_EQUAL("<>"), 
GREATER_OR_EQUAL(">="), 
LESS_OR_EQUAL("<="), 
GREATER(">"), 
LESS("<"), 
IS_NULL("IS NULL");
	
	private final String symbol;
	
	
	private DaoWhereCondition(String condSymbol) {
		symbol = condSymbol;
	}
	
	
	
	public String getSymbol() {
		return symbol;
	}
}
