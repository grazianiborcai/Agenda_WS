package br.com.mind5.business.materialStore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoMatoreSelectSingle extends DaoStmtTemplate<MatoreInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_STORE_TABLE;	
	
	
	public DaoMatoreSelectSingle(Connection conn, MatoreInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatoreInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoMatoreWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
		
	
	
	@Override protected DaoResultParser<MatoreInfo> getResultParserHook() {
		return new DaoResultParser<MatoreInfo>() {
			@Override public List<MatoreInfo> parseResult(MatoreInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatoreInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					MatoreInfo dataInfo = new MatoreInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoMatoreDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(DaoMatoreDbTableColumn.COL_COD_STORE);
					dataInfo.codMat = stmtResult.getLong(DaoMatoreDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoMatoreDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.recordMode = stmtResult.getString(DaoMatoreDbTableColumn.COL_RECORD_MODE);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoMatoreDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoMatoreDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoMatoreDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoMatoreDbTableColumn.COL_CREATED_BY);
					dataInfo.matPrice = DaoFormatter.sqlToDouble(stmtResult, DaoMatoreDbTableColumn.COL_PRICE_STORE);
					dataInfo.matPrice1 = DaoFormatter.sqlToDouble(stmtResult, DaoMatoreDbTableColumn.COL_PRICE_STORE_1);
					dataInfo.matPrice2 = DaoFormatter.sqlToDouble(stmtResult, DaoMatoreDbTableColumn.COL_PRICE_STORE_2);
					dataInfo.matPrice3 = DaoFormatter.sqlToDouble(stmtResult, DaoMatoreDbTableColumn.COL_PRICE_STORE_3);
					dataInfo.matPrice4 = DaoFormatter.sqlToDouble(stmtResult, DaoMatoreDbTableColumn.COL_PRICE_STORE_4);
					dataInfo.matPrice5 = DaoFormatter.sqlToDouble(stmtResult, DaoMatoreDbTableColumn.COL_PRICE_STORE_5);
					dataInfo.matPrice6 = DaoFormatter.sqlToDouble(stmtResult, DaoMatoreDbTableColumn.COL_PRICE_STORE_6);
					dataInfo.matPrice7 = DaoFormatter.sqlToDouble(stmtResult, DaoMatoreDbTableColumn.COL_PRICE_STORE_7);	
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
