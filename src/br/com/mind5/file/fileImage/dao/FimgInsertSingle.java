package br.com.mind5.file.fileImage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import br.com.mind5.file.fileImage.info.FimgInfo;

public final class FimgInsertSingle implements DaoStmt<FimgInfo> {
	private DaoStmt<FimgInfo> stmtSql;
	private DaoStmtOption_<FimgInfo> stmtOption;
	
	
	
	public FimgInsertSingle(Connection conn, FimgInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, FimgInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.FILE_IMG_TABLE;
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

	
	
	@Override public List<FimgInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<FimgInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, FimgInfo recordInfo) throws SQLException {
			
			int i = 1;
			stmt.setLong(i++, recordInfo.codOwner);
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
			stmt.setString(i++, recordInfo.fileImgExtension);
			stmt.setString(i++, recordInfo.fileImgName);
			stmt.setString(i++, recordInfo.recordMode);			
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codStore);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codMat);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);	
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);	
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwnerRef);	
			stmt.setString(i++, recordInfo.fileImgUri);	
			stmt.setString(i++, recordInfo.fileImgPath);	
			stmt.setBoolean(i++, recordInfo.isCover);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codEmployee);
			
			return stmt;
		}		
	}
	
	
	
	@Override public DaoStmt<FimgInfo> getNewInstance() {
		return new FimgInsertSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<FimgInfo> {
		private FimgInfo recordInfo;
		
		public ResultParser(FimgInfo recordToParse) {
			recordInfo = recordToParse;
		}
		
		
		
		@Override public List<FimgInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<FimgInfo> finalResult = new ArrayList<>();
			recordInfo.codFileImg = lastId;
			finalResult.add(recordInfo);			
			return finalResult;
		}
	}
}
