package br.com.mind5.dao;

public enum DaoJoinType {
	INNER_JOIN("INNER JOIN"), 
	LEFT_OUTER_JOIN("LEFT OUTER JOIN"), 
	CROSS_JOIN("CROSS JOIN");
	
	private final String sqlTypeSymbol;
	
	
	private DaoJoinType(String sqlType) {
		sqlTypeSymbol = sqlType;
	}
	
	
	
	@Override public String toString() {
		return sqlTypeSymbol;
	}
}
