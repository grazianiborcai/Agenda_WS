package br.com.mind5.file.sysFileImage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.file.sysFileImage.info.FimgysInfo;

public final class DaoFimgysInsertSingle extends DaoStmtTemplate<FimgysInfo> {
	private final String MAIN_TABLE = DaoDbTable.SYS_FILE_IMG_TABLE;		
	
	
	public DaoFimgysInsertSingle(Connection conn, FimgysInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<FimgysInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<FimgysInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, FimgysInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);
				stmt.setString(i++, recordInfo.fileImgExtension);
				stmt.setString(i++, recordInfo.fileImgName);
				stmt.setString(i++, recordInfo.recordMode);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.lastChanged);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codGroup);	
				stmt.setString(i++, recordInfo.fileImgUri);	
				stmt.setString(i++, recordInfo.fileImgPath);	
				stmt.setBoolean(i++, recordInfo.isCover);
				stmt.setString(i++, recordInfo.fileImgPathExternal);
				stmt.setString(i++, recordInfo.fileImgUriExternal);
				stmt = DaoFormatter.numberToStmt(stmt, i++, recordInfo.codSnapshot);
				
				return stmt;
			}		
		};
	}
	
		
		
	@Override protected DaoResultParser<FimgysInfo> getResultParserHook() {
		return new DaoResultParser<FimgysInfo>() {		
			@Override public List<FimgysInfo> parseResult(FimgysInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FimgysInfo> finalResult = new ArrayList<>();
				recordInfo.codFileImg = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
