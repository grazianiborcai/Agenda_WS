package br.com.mind5.file.fileImage.dao;

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
import br.com.mind5.file.fileImage.info.FimgInfo;

public final class FimgDeleteSingle extends DaoStmtTemplate<FimgInfo> {
	private final String MAIN_TABLE = DaoDbTable.FILE_IMG_TABLE;		
	
	
	public FimgDeleteSingle(Connection conn, FimgInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FimgInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new FimgWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<FimgInfo> getResultParserHook() {
		return new DaoResultParser<FimgInfo>() {
			@Override public List<FimgInfo> parseResult(FimgInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FimgInfo> finalResult = new ArrayList<>();
				FimgInfo emptyInfo = new FimgInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
