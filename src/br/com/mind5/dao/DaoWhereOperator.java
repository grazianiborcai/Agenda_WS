package br.com.mind5.dao;

public enum DaoWhereOperator {
AND("AND"), OR("OR");
	
	private final String symbol;
	
	
	private DaoWhereOperator(String condSymbol) {
		symbol = condSymbol;
	}
	
	
	
	public String getSymbol() {
		return symbol;
	}
}
