package br.com.gda.sql;

public enum SqlOperator {
	EQUAL("=") {
		@Override protected SqlWhereBuilder factoryWhereBuilder(boolean ignoreNullCondition) {
			return new SqlWhereBuilderEqual(ignoreNullCondition);
		};
	},
	
	IS_NULL("IS NULL") {
		@Override protected SqlWhereBuilder factoryWhereBuilder(boolean ignoreNullCondition) {
			return new SqlWhereBuilderIsNull(ignoreNullCondition);
		};
	};
	
	
	private final String operatorSymbol;
	
	
	SqlOperator(String symbol) {
		this.operatorSymbol = symbol;
	}
	
	
	@Override public String toString() {
		return this.operatorSymbol;
	}
	
	
	protected abstract SqlWhereBuilder factoryWhereBuilder(boolean ignoreNullCondition);
}
