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
		
		resultStatement.append(DaoOperation.UPDATE.toString());
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(schemaName);
		resultStatement.append(DaoDictionary.PERIOD);
		resultStatement.append(tableName);
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(DaoDictionary.SET);
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(DaoDictionary.RECORD_MODE);
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(DaoDictionary.EQUAL);
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(DaoDictionary.QUOTE);
		resultStatement.append(RecordMode.DELETED.getCodRecordMode());
		resultStatement.append(DaoDictionary.QUOTE);
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(DaoDictionary.WHERE);
		resultStatement.append(DaoDictionary.SPACE);
		resultStatement.append(whereClause);
		resultStatement.append(DaoDictionary.END_STATEMENT);		
		
		return resultStatement.toString();
	}
}
