package br.com.gda.employee.dao;

import br.com.gda.employee.info.EmpWTimeInfo;
import br.com.gda.helper.RecordMode;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;

final class EmpWtimeStmtWhere {
	private String whereClause;
	
	public EmpWtimeStmtWhere(boolean ignoreNull, EmpWTimeInfo recordInfo) {
		generateWhereClause(ignoreNull, recordInfo);
	}
	
	
	
	private void generateWhereClause(boolean ignoreNull, EmpWTimeInfo recordInfo) {
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.isIgnoringNull = ignoreNull;
		
		SqlWhereBuilder builder = SqlWhereBuilder.factory(whereOption);
		
		builder.appendClauseWithAnd("cod_owner", SqlFormatterNumber.numberToString(recordInfo.codOwner));
		builder.appendClauseWithAnd("cod_store", SqlFormatterNumber.numberToString(recordInfo.codStore));
		builder.appendClauseWithAnd("cod_employee", SqlFormatterNumber.numberToString(recordInfo.codEmployee));
		builder.appendClauseWithAnd("weekday", SqlFormatterNumber.numberToString(recordInfo.weekday));
		builder.appendClauseWithAnd("record_mode", RecordMode.RECORD_OK);
		
		whereClause = builder.generateClause();
	}
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
