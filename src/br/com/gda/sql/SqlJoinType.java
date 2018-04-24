package br.com.gda.sql;

public enum SqlJoinType {
	INNER_JOIN("INNER JOIN"), LEFT_OUTER_JOIN("LEFT OUTER JOIN");
	
	private final String sqlTypeSymbol;
	
	
	private SqlJoinType(String sqlType) {
		this.sqlTypeSymbol = sqlType;
	}
	
	
	
	@Override public String toString() {
		return this.sqlTypeSymbol;
	}
}
