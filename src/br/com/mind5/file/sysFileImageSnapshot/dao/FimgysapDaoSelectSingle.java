package br.com.mind5.file.sysFileImageSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.file.sysFileImageSnapshot.info.FimgysapInfo;

public final class FimgysapDaoSelectSingle extends DaoStmtTemplate<FimgysapInfo> {
	private final String MAIN_TABLE = DaoDbTable.SYS_FILE_IMG_SNAPSHOT_TABLE;		
	
	
	public FimgysapDaoSelectSingle(Connection conn, FimgysapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FimgysapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new FimgysapDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<FimgysapInfo> getResultParserHook() {
		return new DaoResultParser<FimgysapInfo>() {
			@Override public List<FimgysapInfo> parseResult(FimgysapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FimgysapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					FimgysapInfo dataInfo = new FimgysapInfo();
					
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, FimgysapDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codGroup = DaoFormatter.sqlToInt(stmtResult, FimgysapDaoDbTableColumn.COL_COD_MAT_GROUP);
					dataInfo.codFileImg = DaoFormatter.sqlToLong(stmtResult, FimgysapDaoDbTableColumn.COL_COD_FILE_IMG);
					dataInfo.recordMode = stmtResult.getString(FimgysapDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, FimgysapDaoDbTableColumn.COL_CREATED_ON);		
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, FimgysapDaoDbTableColumn.COL_LAST_CHANGED);	
					dataInfo.fileImgName = stmtResult.getString(FimgysapDaoDbTableColumn.COL_FILE_IMG_NAME);
					dataInfo.fileImgExtension = stmtResult.getString(FimgysapDaoDbTableColumn.COL_FILE_IMG_EXTENSION);
					dataInfo.fileImgUri = stmtResult.getString(FimgysapDaoDbTableColumn.COL_FILE_URI);
					dataInfo.fileImgUriExternal = stmtResult.getString(FimgysapDaoDbTableColumn.COL_FILE_URI_EXTERNAL);
					dataInfo.fileImgPath = stmtResult.getString(FimgysapDaoDbTableColumn.COL_IMG_FILE_PATH);
					dataInfo.fileImgPathExternal = stmtResult.getString(FimgysapDaoDbTableColumn.COL_IMG_FILE_PATH_EXTERNAL);
					dataInfo.isCover = DaoFormatter.sqlToBoole(stmtResult, FimgysapDaoDbTableColumn.COL_IS_COVER);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
