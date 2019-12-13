package br.com.mind5.business.materialStock.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MatockSelectSingle extends DaoStmtTemplate<MatockInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_STOCK_TABLE;	
	
	
	public MatockSelectSingle(Connection conn, MatockInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatockInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatockWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<MatockInfo> getResultParserHook() {
		return new DaoResultParserV2<MatockInfo>() {
			@Override public List<MatockInfo> parseResult(MatockInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatockInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					MatockInfo dataInfo = new MatockInfo();
					dataInfo.codOwner = stmtResult.getLong(MatockDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(MatockDbTableColumn.COL_COD_STORE);
					dataInfo.codMat = stmtResult.getLong(MatockDbTableColumn.COL_COD_MATERIAL);
					dataInfo.quantityStock = stmtResult.getInt(MatockDbTableColumn.COL_QUANTITY_STOCK);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, MatockDbTableColumn.COL_LAST_CHANGED);		
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
