package br.com.mind5.file.fileImageSnapshot.dao;

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
import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;

public final class DaoFimgnapInsertSingle extends DaoStmtTemplate<FimgnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.FILE_IMG_SNAPSHOT_TABLE;		
	
	
	public DaoFimgnapInsertSingle(Connection conn, FimgnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.INSERT;
	}
	
	
	
	@Override protected DaoStmtParamTranslator<FimgnapInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<FimgnapInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, FimgnapInfo recordInfo) throws SQLException {		
				int i = 1;
				
				stmt.setLong(i++, recordInfo.codOwner);
				stmt.setLong(i++, recordInfo.codFileImg);
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
				
				return stmt;
			}		
		};
	}
	
		
		
	@Override protected DaoResultParser<FimgnapInfo> getResultParserHook() {
		return new DaoResultParser<FimgnapInfo>() {		
			@Override public List<FimgnapInfo> parseResult(FimgnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FimgnapInfo> finalResult = new ArrayList<>();
				recordInfo.codSnapshot = lastId;
				finalResult.add(recordInfo);			
				return finalResult;
			}
		};
	}
}
