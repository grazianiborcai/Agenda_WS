package br.com.mind5.business.cartItemSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CartemarchSelectSingle extends DaoStmtTemplate<CartemarchInfo> {	
	private final String MAIN_TABLE = DaoDbTable.CART_ITM_TABLE;
	
	
	public CartemarchSelectSingle(Connection conn, CartemarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	} 
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.CART_ITM_SEARCH_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CartemarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new CartemarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
		
	
	
	@Override protected DaoResultParserV2<CartemarchInfo> getResultParserHook() {
		return new DaoResultParserV2<CartemarchInfo>() {
			@Override public List<CartemarchInfo> parseResult(CartemarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {					
				List<CartemarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CartemarchInfo dataInfo = new CartemarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(CartemarchDbTableColumn.COL_COD_OWNER);	
					dataInfo.codUser = stmtResult.getLong(CartemarchDbTableColumn.COL_COD_USER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, CartemarchDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, CartemarchDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, CartemarchDbTableColumn.COL_COD_MATERIAL);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, CartemarchDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, CartemarchDbTableColumn.COL_BEGIN_TIME);			
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
