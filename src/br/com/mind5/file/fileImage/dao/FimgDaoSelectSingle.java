package br.com.mind5.file.fileImage.dao;

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
import br.com.mind5.file.fileImage.info.FimgInfo;

public final class FimgDaoSelectSingle extends DaoStmtTemplate<FimgInfo> {
	private final String MAIN_TABLE = DaoDbTable.FILE_IMG_TABLE;		
	
	
	public FimgDaoSelectSingle(Connection conn, FimgInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FimgInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new FimgDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<FimgInfo> getResultParserHook() {
		return new DaoResultParser<FimgInfo>() {
			@Override public List<FimgInfo> parseResult(FimgInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FimgInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					FimgInfo dataInfo = new FimgInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, FimgDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, FimgDaoDbTableColumn.COL_COD_OWNER_REF);
					dataInfo.codFileImg = DaoFormatter.sqlToLong(stmtResult, FimgDaoDbTableColumn.COL_COD_FILE_IMG);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, FimgDaoDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, FimgDaoDbTableColumn.COL_COD_PERSON);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, FimgDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, FimgDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, FimgDaoDbTableColumn.COL_COD_USER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, FimgDaoDbTableColumn.COL_COD_STORE);
					dataInfo.recordMode = stmtResult.getString(FimgDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, FimgDaoDbTableColumn.COL_CREATED_ON);		
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, FimgDaoDbTableColumn.COL_LAST_CHANGED);	
					dataInfo.fileImgName = stmtResult.getString(FimgDaoDbTableColumn.COL_FILE_IMG_NAME);
					dataInfo.fileImgExtension = stmtResult.getString(FimgDaoDbTableColumn.COL_FILE_IMG_EXTENSION);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, FimgDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, FimgDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.fileImgUri = stmtResult.getString(FimgDaoDbTableColumn.COL_FILE_URI);
					dataInfo.fileImgUriExternal = stmtResult.getString(FimgDaoDbTableColumn.COL_FILE_URI_EXTERNAL);
					dataInfo.fileImgPath = stmtResult.getString(FimgDaoDbTableColumn.COL_IMG_FILE_PATH);
					dataInfo.fileImgPathExternal = stmtResult.getString(FimgDaoDbTableColumn.COL_IMG_FILE_PATH_EXTERNAL);
					dataInfo.isCover = DaoFormatter.sqlToBoole(stmtResult, FimgDaoDbTableColumn.COL_IS_COVER);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, FimgDaoDbTableColumn.COL_COD_SNAPSHOT);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
