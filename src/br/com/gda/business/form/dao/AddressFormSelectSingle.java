package br.com.gda.business.form.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.form.info.AddressFormInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class AddressFormSelectSingle implements DaoStmt<AddressFormInfo> {
	private final String LT_ATTR = DaoDbTable.ADDRESS_FORM_TABLE;
	
	private DaoStmt<AddressFormInfo> stmtSql;
	private DaoStmtOption<AddressFormInfo> stmtOption;
	
	
	
	public AddressFormSelectSingle(Connection conn, AddressFormInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, AddressFormInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_ATTR;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		final boolean IGNORE_NULL = true;
		final boolean IGNORE_RECORD_MODE = true;
		final boolean DUMMY_CLAUSE_ALLOWED = true;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new AddressFormWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption);
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

	
	
	@Override public List<AddressFormInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<AddressFormInfo> getNewInstance() {
		return new AddressFormSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements DaoResultParser<AddressFormInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<AddressFormInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<AddressFormInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
				return finalResult;
		
			do {				
				AddressFormInfo dataInfo = new AddressFormInfo();
				dataInfo.codCountry = stmtResult.getString(FormDbTableColumn.COL_COD_COUNTRY);
				dataInfo.codForm = stmtResult.getString(FormDbTableColumn.COL_COD_FORM);
				
				finalResult.add(dataInfo);				
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
