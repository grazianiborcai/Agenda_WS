package br.com.mind5.file.fileImageSearch.dao;

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
import br.com.mind5.file.fileImageSearch.info.FimarchInfo;

public final class FimarchSelectSingle extends DaoStmtTemplate<FimarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.FILE_IMG_TABLE;
	
	
	public FimarchSelectSingle(Connection conn, FimarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FimarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new FimarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParserV2<FimarchInfo> getResultParserHook() {
		return new DaoResultParserV2<FimarchInfo>() {
			@Override public List<FimarchInfo> parseResult(FimarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FimarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					FimarchInfo dataInfo = new FimarchInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, FimarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codFileImg = DaoFormatter.sqlToLong(stmtResult, FimarchDbTableColumn.COL_COD_FILE_IMG);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, FimarchDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, FimarchDbTableColumn.COL_COD_PERSON);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, FimarchDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, FimarchDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, FimarchDbTableColumn.COL_COD_USER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, FimarchDbTableColumn.COL_COD_STORE);
					dataInfo.recordMode = stmtResult.getString(FimarchDbTableColumn.COL_RECORD_MODE);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
