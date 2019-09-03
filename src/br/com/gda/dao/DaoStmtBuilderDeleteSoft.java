package br.com.gda.dao;

import java.util.List;

import br.com.gda.business.masterData.info.common.RecordMode;

final class DaoStmtBuilderDeleteSoft extends DaoStmtBuilderTemplate {

	DaoStmtBuilderDeleteSoft(DaoStmtBuilderOption option) {
		super(option, DaoStmtBuilderDeleteSoft.class);
	}
	
	
	
	@Override protected void checkStmtBuildHook() {			
		super.checkWhereClause();
	}
	
	
	
	@Override protected String buildStmtHook(String schemaName, String tableName, String whereClause, List<DaoColumn> columns, List<DaoJoin> joins) {
		StringBuilder resultStatement = new StringBuilder();
		
		resultStatement = appendOperation(resultStatement);
		resultStatement = appendTable(resultStatement, schemaName, tableName);
		resultStatement = appendColumn(resultStatement);
		resultStatement = appendWhere(resultStatement, whereClause);
		
		return resultStatement.toString();
	}
	
	
	
	private StringBuilder appendOperation(StringBuilder statement) {
		statement.append(DaoOperation.UPDATE.toString());
		statement.append(DaoDictionary.SPACE);
		
		return statement;
	}
	
	
	
	private StringBuilder appendTable(StringBuilder statement, String schemaName, String tableName) {
		statement.append(schemaName);
		statement.append(DaoDictionary.PERIOD);
		statement.append(tableName);
		statement.append(DaoDictionary.SPACE);
		statement.append(DaoDictionary.SET);
		statement.append(DaoDictionary.SPACE);
		
		return statement;		
	}	
	
	
	
	private StringBuilder appendColumn(StringBuilder statement) {
		statement.append(DaoDictionary.RECORD_MODE);
		statement.append(DaoDictionary.SPACE);
		statement.append(DaoDictionary.EQUAL);
		statement.append(DaoDictionary.SPACE);
		statement.append(DaoDictionary.QUOTE);
		statement.append(RecordMode.DELETED.getCodRecordMode());
		statement.append(DaoDictionary.QUOTE);
		statement.append(DaoDictionary.SPACE);
		
		return statement;
	}
	
	
	
	private StringBuilder appendWhere(StringBuilder statement, String whereClause) {
		statement.append(DaoDictionary.WHERE);
		statement.append(DaoDictionary.SPACE);
		statement.append(whereClause);
		statement.append(DaoDictionary.END_STATEMENT);
		
		return statement;	
	}
}
