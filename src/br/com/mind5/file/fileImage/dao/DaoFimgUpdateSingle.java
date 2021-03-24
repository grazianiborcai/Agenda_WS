package br.com.mind5.file.fileImage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.file.fileImage.info.FimgInfo;

public final class DaoFimgUpdateSingle extends DaoStmtTemplate<FimgInfo> {
	private final String MAIN_TABLE = DaoDbTable.FILE_IMG_TABLE;	
	
	
	public DaoFimgUpdateSingle(Connection conn, FimgInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);	
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FimgInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new DaoFimgWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<FimgInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<FimgInfo>() {	
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, FimgInfo recordInfo) throws SQLException {			
				int i = 1;
				
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
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codCustomer);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codUser);
				stmt.setString(i++, recordInfo.fileImgPathExternal);
				stmt.setString(i++, recordInfo.fileImgUriExternal);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codGroup);
				
				return stmt;
			}		
		};
	}
}
