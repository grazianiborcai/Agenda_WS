package br.com.mind5.file.fileImageSnapshot.dao;

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
import br.com.mind5.file.fileImageSnapshot.info.FimgnapInfo;

public final class FimgnapDaoSelectSingle extends DaoStmtTemplate<FimgnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.FILE_IMG_SNAPSHOT_TABLE;		
	
	
	public FimgnapDaoSelectSingle(Connection conn, FimgnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FimgnapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new FimgnapDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<FimgnapInfo> getResultParserHook() {
		return new DaoResultParser<FimgnapInfo>() {
			@Override public List<FimgnapInfo> parseResult(FimgnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FimgnapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					FimgnapInfo dataInfo = new FimgnapInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, FimgnapDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, FimgnapDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, FimgnapDaoDbTableColumn.COL_COD_OWNER_REF);
					dataInfo.codFileImg = DaoFormatter.sqlToLong(stmtResult, FimgnapDaoDbTableColumn.COL_COD_FILE_IMG);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, FimgnapDaoDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, FimgnapDaoDbTableColumn.COL_COD_PERSON);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, FimgnapDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, FimgnapDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, FimgnapDaoDbTableColumn.COL_COD_USER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, FimgnapDaoDbTableColumn.COL_COD_STORE);
					dataInfo.recordMode = stmtResult.getString(FimgnapDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, FimgnapDaoDbTableColumn.COL_CREATED_ON);		
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, FimgnapDaoDbTableColumn.COL_LAST_CHANGED);	
					dataInfo.fileImgName = stmtResult.getString(FimgnapDaoDbTableColumn.COL_FILE_IMG_NAME);
					dataInfo.fileImgExtension = stmtResult.getString(FimgnapDaoDbTableColumn.COL_FILE_IMG_EXTENSION);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, FimgnapDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, FimgnapDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.fileImgUri = stmtResult.getString(FimgnapDaoDbTableColumn.COL_FILE_URI);
					dataInfo.fileImgUriExternal = stmtResult.getString(FimgnapDaoDbTableColumn.COL_FILE_URI_EXTERNAL);
					dataInfo.fileImgPath = stmtResult.getString(FimgnapDaoDbTableColumn.COL_IMG_FILE_PATH);
					dataInfo.fileImgPathExternal = stmtResult.getString(FimgnapDaoDbTableColumn.COL_IMG_FILE_PATH_EXTERNAL);
					dataInfo.isCover = DaoFormatter.sqlToBoole(stmtResult, FimgnapDaoDbTableColumn.COL_IS_COVER);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
