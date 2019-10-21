package br.com.mind5.business.materialMovement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper;
import br.com.mind5.dao.DaoStmtOption;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;

public final class MatmovInsertSingle implements DaoStmt<MatmovInfo> {
	private DaoStmt<MatmovInfo> stmtSql;
	private DaoStmtOption<MatmovInfo> stmtOption;
	
	
	
	public MatmovInsertSingle(Connection conn, MatmovInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, MatmovInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.MAT_MOVEMENT_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = new ResultParser(recordInfo);
		this.stmtOption.whereClause = null;
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.INSERT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<MatmovInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<MatmovInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, MatmovInfo recordInfo) throws SQLException {
			Timestamp lastChanged = DaoFormatter.localToSqlTimestamp((recordInfo.lastChanged));
			Date postingDate = DaoFormatter.localToSqlDate((recordInfo.postingDate));
			
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt.setString(i++, DaoFormatter.charToString(recordInfo.codMatmovType));
			stmt.setLong(i++, recordInfo.codMat);
			stmt.setLong(i++, recordInfo.codStore);
			stmt.setTimestamp(i++, lastChanged);			
			
			if (recordInfo.lastChangedBy >= 0) {
				stmt.setLong(i++, recordInfo.lastChangedBy);
			} else {
				stmt.setNull(i++, Types.INTEGER);
			}			
			
			stmt.setInt(i++, recordInfo.quantity);	
			stmt.setDate(i++, postingDate);
			
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<MatmovInfo> getNewInstance() {
		return new MatmovInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements DaoResultParser<MatmovInfo> {
		private MatmovInfo recordInfo;
		
		public ResultParser(MatmovInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<MatmovInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<MatmovInfo> finalResult = new ArrayList<>();
			recordInfo.codMatmov = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
