package br.com.gda.employee.dao;

import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;

final class EmpWtimeStmtWhere {
	private String whereClause;
	
	
	
	public EmpWtimeStmtWhere(SqlWhereBuilderOption whereOption, EmpWTimeInfo recordInfo) {
		generateWhereClause(whereOption, recordInfo);
	}
	
	
	
	private void generateWhereClause(SqlWhereBuilderOption whereOption, EmpWTimeInfo recordInfo) {
		SqlWhereBuilder builder = SqlWhereBuilder.factory(whereOption);
		
		builder.appendClauseWithAnd("cod_owner", SqlFormatterNumber.numberToString(recordInfo.codOwner));
		builder.appendClauseWithAnd("cod_store", SqlFormatterNumber.numberToString(recordInfo.codStore));
		builder.appendClauseWithAnd("cod_employee", SqlFormatterNumber.numberToString(recordInfo.codEmployee));
		builder.appendClauseWithAnd("weekday", SqlFormatterNumber.numberToString(recordInfo.weekday));
		builder.appendClauseWithAnd("record_mode", recordInfo.recordMode);
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
