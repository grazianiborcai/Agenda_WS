package br.com.gda.business.employeeWorkTime.dao;

import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.sql.SqlColumn;
import br.com.gda.sql.SqlDbTableColumnAll;
import br.com.gda.sql.SqlFormatterNumber;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilder;
import br.com.gda.sql.SqlWhereBuilderOption;
import br.com.gda.sql.SqlWhereCondition;
import br.com.gda.sql.SqlWhereOperator;

public final class EmpWTimeWhereTime implements SqlStmtWhere {
	private String whereClause;	
	private SqlWhereBuilder builderKey;
	private SqlWhereBuilder builderBeginTime;
	private SqlWhereBuilder builderEndTime;
	
	
	public EmpWTimeWhereTime(SqlWhereBuilderOption whereOption, String tableName, EmpWTimeInfo recordInfo) {
		generateWhereClause(whereOption, tableName, recordInfo);
	}
	
	
	
	private void generateWhereClause(SqlWhereBuilderOption whereOption, String tableName, EmpWTimeInfo recordInfo) {
		builderKey = SqlWhereBuilder.factory(whereOption);		
		builderBeginTime = SqlWhereBuilder.factory(whereOption);
		builderEndTime = SqlWhereBuilder.factory(whereOption);		
		
		List<SqlColumn> columns = SqlDbTableColumnAll.getTableColumnsAsList(tableName);
		
		for (SqlColumn eachColumn : columns) {
			generateKey(eachColumn, recordInfo);
			generateBeginTime(eachColumn, recordInfo);
			generateEndTime(eachColumn, recordInfo);
		}
		
		
		builderBeginTime.mergeBuilder(builderEndTime, SqlWhereOperator.OR);
		builderKey.mergeBuilder(builderBeginTime, SqlWhereOperator.AND);
		
		whereClause = builderKey.generateClause();
	}
	
	
	
	private void generateKey(SqlColumn column, EmpWTimeInfo recordInfo) {
		switch(column.columnName) {
		case "cod_owner" :
			builderKey.addClauseEqualAnd(column, SqlFormatterNumber.numberToString(recordInfo.codOwner));
			break;

		case "cod_employee" :
			builderKey.addClauseEqualAnd(column, SqlFormatterNumber.numberToString(recordInfo.codEmployee));
			break;
			
		case "weekday" :
			builderKey.addClauseEqualAnd(column, SqlFormatterNumber.numberToString(recordInfo.codWeekday));
			break;
			
		case "record_mode" :
			builderKey.addClauseEqualAnd(column, recordInfo.recordMode);
			break;
		}
	}
	
	
	
	private void generateBeginTime(SqlColumn column, EmpWTimeInfo recordInfo) {
		switch(column.columnName) {
		case "begin_time" :
			builderBeginTime.addClauseAnd(column, SqlFormatterNumber.timeToString(recordInfo.beginTime), SqlWhereCondition.LESS_OR_EQUAL);
			break;
			
		case "end_time" :
			builderBeginTime.addClauseAnd(column, SqlFormatterNumber.timeToString(recordInfo.beginTime), SqlWhereCondition.GREATER_OR_EQUAL);
			break;
		}
	}	
	
	
	
	private void generateEndTime(SqlColumn column, EmpWTimeInfo recordInfo) {
		switch(column.columnName) {
		case "begin_time" :
			builderEndTime.addClauseAnd(column, SqlFormatterNumber.timeToString(recordInfo.endTime), SqlWhereCondition.LESS_OR_EQUAL);
			break;
			
		case "end_time" :
			builderEndTime.addClauseAnd(column, SqlFormatterNumber.timeToString(recordInfo.endTime), SqlWhereCondition.GREATER_OR_EQUAL);
			break;
		}
	}	
	
	
	
	public String getWhereClause() {
		return whereClause;
	}
}
