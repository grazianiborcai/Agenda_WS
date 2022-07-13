package br.com.mind5.file.sysFileImage.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.file.sysFileImage.info.FimgysInfo;

public final class FimgysDaoDeleteSingle extends DaoStmtTemplate<FimgysInfo> {
	private final String MAIN_TABLE = DaoDbTable.SYS_FILE_IMG_TABLE;		
	
	
	public FimgysDaoDeleteSingle(Connection conn, FimgysInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FimgysInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new FimgysDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<FimgysInfo> getResultParserHook() {
		return new DaoResultParser<FimgysInfo>() {
			@Override public List<FimgysInfo> parseResult(FimgysInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FimgysInfo> finalResult = new ArrayList<>();
				FimgysInfo emptyInfo = new FimgysInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
