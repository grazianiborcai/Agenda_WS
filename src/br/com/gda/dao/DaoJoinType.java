package br.com.gda.dao;

public enum DaoJoinType {
	INNER_JOIN("INNER JOIN"), LEFT_OUTER_JOIN("LEFT OUTER JOIN");
	
	private final String sqlTypeSymbol;
	
	
	private DaoJoinType(String sqlType) {
		this.sqlTypeSymbol = sqlType;
	}
	
	
	
	@Override public String toString() {
		return this.sqlTypeSymbol;
	}
}
