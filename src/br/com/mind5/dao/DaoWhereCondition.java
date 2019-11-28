package br.com.mind5.dao;

public enum DaoWhereCondition {
	EQUAL("="), 
	GREATER(">"), 
	GREATER_OR_EQUAL(">="), 
	IS_NULL("IS NULL"),
	LESS("<"), 
	LESS_OR_EQUAL("<="), 
	LIKE("LIKE"), 
	NOT_EQUAL("<>");
	
	private final String symbol;
	
	
	private DaoWhereCondition(String condSymbol) {
		symbol = condSymbol;
	}
	
	
	
	public String getSymbol() {
		return symbol;
	}
}
