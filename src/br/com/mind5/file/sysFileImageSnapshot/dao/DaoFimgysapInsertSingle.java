package br.com.mind5.file.sysFileImageSnapshot.dao;

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
import br.com.mind5.file.sysFileImageSnapshot.info.FimgysapInfo;

public final class DaoFimgysapInsertSingle extends DaoStmtTemplate<FimgysapInfo> {
	private final String MAIN_TABLE = DaoDbTable.FILE_IMG_SNAPSHOT_TABLE;		
	
	
	public DaoFimgysapInsertSingle(Connection conn, FimgysapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<FimgysapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<FimgysapInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, FimgysapInfo recordInfo) throws SQLException {		
				int i = 1;
				

				stmt.setLong(i++, recordInfo.codFileImg);
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
				
				return stmt;
			}		
		};
	}
	
		
		
	@Override protected DaoResultParser<FimgysapInfo> getResultParserHook() {
		return new DaoResultParser<FimgysapInfo>() {		
			@Override public List<FimgysapInfo> parseResult(FimgysapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FimgysapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
