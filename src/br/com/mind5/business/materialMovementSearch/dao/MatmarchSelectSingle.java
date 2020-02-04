package br.com.mind5.business.materialMovementSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MatmarchSelectSingle extends DaoStmtTemplate<MatmarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_MOVEMENT_TABLE;	
	
	
	public MatmarchSelectSingle(Connection conn, MatmarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.MAT_MOVEMENT_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatmarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatmarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<MatmarchInfo> getResultParserHook() {
		return new DaoResultParser<MatmarchInfo>() {
			@Override public List<MatmarchInfo> parseResult(MatmarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatmarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					MatmarchInfo dataInfo = new MatmarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(MatmarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(MatmarchDbTableColumn.COL_COD_STORE);
					dataInfo.codMatmov = stmtResult.getLong(MatmarchDbTableColumn.COL_COD_MAT_MOV);
					dataInfo.codMat = stmtResult.getLong(MatmarchDbTableColumn.COL_COD_MATERIAL);
					dataInfo.postingYear = stmtResult.getInt(MatmarchDbTableColumn.COL_POSTING_YEAR);
					dataInfo.postingYearMonth = stmtResult.getInt(MatmarchDbTableColumn.COL_POSTING_YEAR_MONTH);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
