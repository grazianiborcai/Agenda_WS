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

public final class DaoFimgnapSelectSingle extends DaoStmtTemplate<FimgnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.FILE_IMG_SNAPSHOT_TABLE;		
	
	
	public DaoFimgnapSelectSingle(Connection conn, FimgnapInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new DaoFimgnapWhere(whereOption, tableName, recordInfo);
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
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoFimgnapDbTableColumn.COL_COD_OWNER);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoFimgnapDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, DaoFimgnapDbTableColumn.COL_COD_OWNER_REF);
					dataInfo.codFileImg = DaoFormatter.sqlToLong(stmtResult, DaoFimgnapDbTableColumn.COL_COD_FILE_IMG);
					dataInfo.codGroup = DaoFormatter.sqlToInt(stmtResult, DaoFimgnapDbTableColumn.COL_COD_MAT_GROUP);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, DaoFimgnapDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, DaoFimgnapDbTableColumn.COL_COD_PERSON);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, DaoFimgnapDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, DaoFimgnapDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoFimgnapDbTableColumn.COL_COD_USER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoFimgnapDbTableColumn.COL_COD_STORE);
					dataInfo.recordMode = stmtResult.getString(DaoFimgnapDbTableColumn.COL_RECORD_MODE);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoFimgnapDbTableColumn.COL_CREATED_ON);		
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoFimgnapDbTableColumn.COL_LAST_CHANGED);	
					dataInfo.fileImgName = stmtResult.getString(DaoFimgnapDbTableColumn.COL_FILE_IMG_NAME);
					dataInfo.fileImgExtension = stmtResult.getString(DaoFimgnapDbTableColumn.COL_FILE_IMG_EXTENSION);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoFimgnapDbTableColumn.COL_CREATED_BY);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoFimgnapDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.fileImgUri = stmtResult.getString(DaoFimgnapDbTableColumn.COL_FILE_URI);
					dataInfo.fileImgUriExternal = stmtResult.getString(DaoFimgnapDbTableColumn.COL_FILE_URI_EXTERNAL);
					dataInfo.fileImgPath = stmtResult.getString(DaoFimgnapDbTableColumn.COL_IMG_FILE_PATH);
					dataInfo.fileImgPathExternal = stmtResult.getString(DaoFimgnapDbTableColumn.COL_IMG_FILE_PATH_EXTERNAL);
					dataInfo.isCover = DaoFormatter.sqlToBoole(stmtResult, DaoFimgnapDbTableColumn.COL_IS_COVER);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
