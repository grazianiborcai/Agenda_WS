package br.com.mind5.business.personSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PerarchSelectSingle implements DaoStmt<PerarchInfo> {
	private final String LT_PERSON = DaoDbTable.PERSON_TABLE;
	
	private DaoStmt<PerarchInfo> stmtSql;
	private DaoStmtOption<PerarchInfo> stmtOption;
	
	
	
	public PerarchSelectSingle(Connection conn, PerarchInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PerarchInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_PERSON;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.PERSON_SEARCH_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PerarchWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
	}
	
	

	@Override public void generateStmt() throws SQLException {
		stmtSql.generateStmt();		
	}

	
	
	@Override public boolean checkStmtGeneration() {
		return stmtSql.checkStmtGeneration();
	}

	
	
	@Override public void executeStmt() throws SQLException {
		stmtSql.executeStmt();
	}

	
	
	@Override public List<PerarchInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PerarchInfo> getNewInstance() {
		return new PerarchSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<PerarchInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<PerarchInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PerarchInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				PerarchInfo dataInfo = new PerarchInfo();
				dataInfo.codOwner = stmtResult.getLong(PerarchDbTableColumn.COL_COD_OWNER);
				dataInfo.codPerson = stmtResult.getLong(PerarchDbTableColumn.COL_COD_PERSON);
				dataInfo.cpf = stmtResult.getString(PerarchDbTableColumn.COL_CPF);
				dataInfo.name = stmtResult.getString(PerarchDbTableColumn.COL_NAME);			
				dataInfo.email = stmtResult.getString(PerarchDbTableColumn.COL_EMAIL);						
				dataInfo.recordMode = stmtResult.getString(PerarchDbTableColumn.COL_RECORD_MODE);
				dataInfo.codEntityCateg = stmtResult.getString(PerarchDbTableColumn.COL_COD_ENTITY_CATEG);
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, PerarchDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.codGender = DaoFormatter.sqlToInt(stmtResult, PerarchDbTableColumn.COL_COD_GENDER);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, PerarchDbTableColumn.COL_LAST_CHANGED);
				dataInfo.lastChangedBy = DaoFormatter.sqlToInt(stmtResult, PerarchDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.birthDate = DaoFormatter.sqlToLocalDate(stmtResult, PerarchDbTableColumn.COL_BIRTH_DATE);
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
