package br.com.gda.file.fileImage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
import br.com.gda.dao.common.DaoOptionValue;
import br.com.gda.file.fileImage.info.FimgInfo;

public final class FimgUpdateSingle implements DaoStmt<FimgInfo> {
	private DaoStmt<FimgInfo> stmtSql;
	private DaoStmtOption<FimgInfo> stmtOption;
	
	
	public FimgUpdateSingle(Connection conn, FimgInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, FimgInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = DaoDbTable.FILE_IMG_TABLE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(this.stmtOption.tableName);
		this.stmtOption.stmtParamTranslator = new ParamTranslator();
		this.stmtOption.resultParser = null;
		this.stmtOption.whereClause = buildWhereClause();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new FimgWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.UPDATE, this.stmtOption, this.getClass());
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
	
	
	
	@Override public DaoStmt<FimgInfo> getNewInstance() {
		return new FimgUpdateSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ParamTranslator implements DaoStmtParamTranslator<FimgInfo> {		
		@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, FimgInfo recordInfo) throws SQLException {
			
			int i = 1;
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
			stmt.setString(i++, recordInfo.fileImgExtension);
			stmt.setString(i++, recordInfo.fileImgName);
			stmt.setString(i++, recordInfo.recordMode);			
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codPerson);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCompany);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codMat);		
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.createdBy);	
			stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.lastChangedBy);	
			stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codOwnerRef);
			stmt.setString(i++, recordInfo.fileImgUri);	
			stmt.setString(i++, recordInfo.fileImgPath);
			
			return stmt;
		}		
	}
}
