package br.com.gda.sql;

public enum SqlWhereOperator {
AND("AND"), OR("OR");
	
	private final String symbol;
	
	
	private SqlWhereOperator(String condSymbol) {
		symbol = condSymbol;
	}
	
	
	
	public String getSymbol() {
		return symbol;
	}
}
