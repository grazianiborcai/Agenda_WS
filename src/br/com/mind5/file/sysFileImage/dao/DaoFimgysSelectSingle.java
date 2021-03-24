package br.com.mind5.file.sysFileImage.dao;

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
import br.com.mind5.file.sysFileImage.info.FimgysInfo;

public final class DaoFimgysSelectSingle extends DaoStmtTemplate<FimgysInfo> {
	private final String MAIN_TABLE = DaoDbTable.SYS_FILE_IMG_TABLE;		
	
	
	public DaoFimgysSelectSingle(Connection conn, FimgysInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FimgysInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoFimgysWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<FimgysInfo> getResultParserHook() {
		return new DaoResultParser<FimgysInfo>() {
			@Override public List<FimgysInfo> parseResult(FimgysInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FimgysInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					FimgysInfo dataInfo = new FimgysInfo();
					
					dataInfo.codGroup = DaoFormatter.sqlToInt(stmtResult, DaoFimgysDbTableColumn.COL_COD_MAT_GROUP);
					dataInfo.codFileImg = DaoFormatter.sqlToLong(stmtResult, DaoFimgysDbTableColumn.COL_COD_FILE_IMG);
					dataInfo.recordMode = stmtResult.getString(DaoFimgysDbTableColumn.COL_RECORD_MODE);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoFimgysDbTableColumn.COL_CREATED_ON);		
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoFimgysDbTableColumn.COL_LAST_CHANGED);	
					dataInfo.fileImgName = stmtResult.getString(DaoFimgysDbTableColumn.COL_FILE_IMG_NAME);
					dataInfo.fileImgExtension = stmtResult.getString(DaoFimgysDbTableColumn.COL_FILE_IMG_EXTENSION);
					dataInfo.fileImgUri = stmtResult.getString(DaoFimgysDbTableColumn.COL_FILE_URI);
					dataInfo.fileImgUriExternal = stmtResult.getString(DaoFimgysDbTableColumn.COL_FILE_URI_EXTERNAL);
					dataInfo.fileImgPath = stmtResult.getString(DaoFimgysDbTableColumn.COL_IMG_FILE_PATH);
					dataInfo.fileImgPathExternal = stmtResult.getString(DaoFimgysDbTableColumn.COL_IMG_FILE_PATH_EXTERNAL);
					dataInfo.isCover = DaoFormatter.sqlToBoole(stmtResult, DaoFimgysDbTableColumn.COL_IS_COVER);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoFimgysDbTableColumn.COL_COD_SNAPSHOT);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
