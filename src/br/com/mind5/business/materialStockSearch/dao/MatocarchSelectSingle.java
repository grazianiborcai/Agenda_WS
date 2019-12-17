package br.com.mind5.business.materialStockSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStockSearch.info.MatocarchInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MatocarchSelectSingle extends DaoStmtTemplate<MatocarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_STOCK_TABLE;	
	
	
	public MatocarchSelectSingle(Connection conn, MatocarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	protected String getLookupTableHook() {
		return DaoDbTable.MAT_STOCK_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatocarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatocarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<MatocarchInfo> getResultParserHook() {
		return new DaoResultParserV2<MatocarchInfo>() {
			@Override public List<MatocarchInfo> parseResult(MatocarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatocarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					MatocarchInfo dataInfo = new MatocarchInfo();
					dataInfo.codOwner = stmtResult.getLong(MatocarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(MatocarchDbTableColumn.COL_COD_STORE);
					dataInfo.codMat = stmtResult.getLong(MatocarchDbTableColumn.COL_COD_MATERIAL);		
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
