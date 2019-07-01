package br.com.gda.payment.creditCard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import br.com.gda.payment.creditCard.info.CrecardInfo;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtParamTranslator;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class CrecardUpdateSingle implements DaoStmt<CrecardInfo> {
	private DaoStmt<CrecardInfo> stmtSql;
	private DaoStmtOption<CrecardInfo> stmtOption;
	
	
	public CrecardUpdateSingle(Connection conn, CrecardInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, CrecardInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.CREDIT_CARD_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = null;
		this.stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoWhereBuilderOption.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new CrecardWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
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

	
	
	@Override public List<CrecardInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<CrecardInfo> getNewInstance() {
		return new CrecardUpdateSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<CrecardInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CrecardInfo recordInfo) throws SQLException {
			
			int i = 1;
			stmt.setString(i++, recordInfo.creditCardId);
			stmt.setString(i++, recordInfo.creditCardBrand);
			stmt.setString(i++, recordInfo.creditCardLast4);
			stmt.setString(i++, recordInfo.recordMode);
			stmt.setTimestamp(i++, DaoFormatter.localToSqlTimestamp(recordInfo.lastChanged));
			
			if (recordInfo.lastChangedBy >= 0) {
				stmt.setLong(i++, recordInfo.lastChangedBy);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}
			
			
			if (recordInfo.codAddressHolder >= 0) {
				stmt.setLong(i++, recordInfo.codAddressHolder);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}	
			
			
			if (recordInfo.codAddressSnapshotHolder >= 0) {
				stmt.setLong(i++, recordInfo.codAddressSnapshotHolder);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}		
			
			
			if (recordInfo.codPhoneHolder >= 0) {
				stmt.setLong(i++, recordInfo.codPhoneHolder);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}		
			
			
			if (recordInfo.codPhoneSnapshotHolder >= 0) {
				stmt.setLong(i++, recordInfo.codPhoneSnapshotHolder);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}		
			
			return stmt;
		}		
	}
}
