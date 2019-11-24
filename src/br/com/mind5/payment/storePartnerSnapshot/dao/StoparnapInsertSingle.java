package br.com.mind5.payment.storePartnerSnapshot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class StoparnapInsertSingle implements DaoStmt<StoparnapInfo> {
	private DaoStmt<StoparnapInfo> stmtSql;
	private DaoStmtOption_<StoparnapInfo> stmtOption;
	
	
	
	public StoparnapInsertSingle(Connection conn, StoparnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, StoparnapInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.PAY_PARTNER_STORE_SNAPSHOT_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = new ResultParser(recordInfo);
		this.stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper_<>(DaoOperation.INSERT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<StoparnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<StoparnapInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, StoparnapInfo recordInfo) throws SQLException {
			
			Timestamp lastChanged = null;
			if(recordInfo.lastChanged != null)
				lastChanged = Timestamp.valueOf((recordInfo.lastChanged));
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			
			
			if (DaoFormatter.boxNumber(recordInfo.codStore) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codStore);
			}
			
			
			if (DaoFormatter.boxNumber(recordInfo.codPayPartner) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.codPayPartner);
			}
			
			
			stmt.setString(i++, recordInfo.recordMode);			
			stmt.setTimestamp(i++, lastChanged);
			
			
			if (DaoFormatter.boxNumber(recordInfo.lastChangedBy) == null) {
				stmt.setNull(i++, Types.INTEGER);
			} else {
				stmt.setLong(i++, recordInfo.lastChangedBy);
			}
			
			
			stmt.setString(i++, recordInfo.codePayPartnerStore);
			stmt.setString(i++, recordInfo.idPayPartnerStore);
			stmt.setString(i++, recordInfo.accessToken);
			stmt.setString(i++, recordInfo.refreshToken);
			stmt.setString(i++, recordInfo.scope);
			stmt.setDate(i++, DaoFormatter.localToSqlDate(recordInfo.tokenExpiresIn));
			
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<StoparnapInfo> getNewInstance() {
		return new StoparnapInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<StoparnapInfo> {
		private StoparnapInfo recordInfo;
		
		public ResultParser(StoparnapInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<StoparnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StoparnapInfo> finalResult = new ArrayList<>();
			recordInfo.codSnapshot = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
