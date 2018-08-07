package br.com.gda.business.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class StoreUpdateSingle implements DaoStmt<StoreInfo> {
	private DaoStmt<StoreInfo> stmtSql;
	private DaoStmtOption<StoreInfo> stmtOption;
	
	
	public StoreUpdateSingle(Connection conn, StoreInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, StoreInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.STORE_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = null;
		this.stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		final boolean DONT_IGNORE_NULL = false;
		final boolean IGNORE_NON_PK = true;
		final boolean IGNORE_RECORD_MODE = true;		
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = IGNORE_NON_PK;
		
		StoreInfo enforcedInfo = enforceUpdateByKey(stmtOption.recordInfo);
		DaoStmtWhere whereClause = new StoreWhere(whereOption, stmtOption.tableName, enforcedInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private StoreInfo enforceUpdateByKey(StoreInfo recordInfo) {
		StoreInfo enforcedInfo = new StoreInfo();
		enforcedInfo.codOwner = recordInfo.codOwner;
		enforcedInfo.codStore = recordInfo.codStore;
		return enforcedInfo;
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.UPDATE, this.stmtOption);
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

	
	
	@Override public List<StoreInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<StoreInfo> getNewInstance() {
		return new StoreUpdateSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<StoreInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StoreInfo recordInfo) throws SQLException {			
			int i = 1;
			stmt.setString(i++, recordInfo.cnpj);
			stmt.setString(i++, recordInfo.inscrMun);
			stmt.setString(i++, recordInfo.inscrEst);
			stmt.setString(i++, recordInfo.razaoSocial);
			stmt.setString(i++, recordInfo.name);
			stmt.setString(i++, recordInfo.address1);
			stmt.setString(i++, recordInfo.address2);
			stmt.setLong(i++, recordInfo.postalCode);
			stmt.setString(i++, recordInfo.city);
			stmt.setString(i++, recordInfo.codCountry);
			stmt.setString(i++, recordInfo.stateProvince);
			stmt.setString(i++, recordInfo.phone);	
			stmt.setString(i++, recordInfo.codCurr);
			stmt.setString(i++, recordInfo.codPayment);
			stmt.setDouble(i++, recordInfo.latitude);
			stmt.setDouble(i++, recordInfo.longitude);
			stmt.setString(i++, recordInfo.codTimezone);
			stmt.setString(i++, recordInfo.recordMode);
			
			return stmt;
		}		
	}
}
