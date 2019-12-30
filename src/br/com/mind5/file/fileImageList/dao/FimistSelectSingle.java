package br.com.mind5.file.fileImageList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.file.fileImageList.info.FimistInfo;

public final class FimistSelectSingle extends DaoStmtTemplate<FimistInfo> {
	private final String MAIN_TABLE = DaoDbTable.FILE_IMG_TABLE;
	
	
	public FimistSelectSingle(Connection conn, FimistInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.FILE_IMG_LIST_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FimistInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new FimistWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
		
	
	
	@Override protected DaoResultParserV2<FimistInfo> getResultParserHook() {
		return new DaoResultParserV2<FimistInfo>() {
			@Override public List<FimistInfo> parseResult(FimistInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FimistInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					FimistInfo dataInfo = new FimistInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, FimistDbTableColumn.COL_COD_OWNER);
					dataInfo.codOwnerRef = DaoFormatter.sqlToLong(stmtResult, FimistDbTableColumn.COL_COD_OWNER_REF);
					dataInfo.codFileImg = DaoFormatter.sqlToLong(stmtResult, FimistDbTableColumn.COL_COD_FILE_IMG);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, FimistDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, FimistDbTableColumn.COL_COD_PERSON);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, FimistDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, FimistDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, FimistDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.recordMode = stmtResult.getString(FimistDbTableColumn.COL_RECORD_MODE);	
					dataInfo.fileImgExtension = stmtResult.getString(FimistDbTableColumn.COL_FILE_IMG_EXTENSION);
					dataInfo.fileImgUri = stmtResult.getString(FimistDbTableColumn.COL_FILE_URI);
					dataInfo.isCover = DaoFormatter.sqlToBoole(stmtResult, FimistDbTableColumn.COL_IS_COVER);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
