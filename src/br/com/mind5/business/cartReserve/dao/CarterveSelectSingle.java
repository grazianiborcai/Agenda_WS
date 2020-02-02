package br.com.mind5.business.cartReserve.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartReserve.info.CarterveInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CarterveSelectSingle extends DaoStmtTemplate<CarterveInfo> {
	private final String MAIN_TABLE = DaoDbTable.CART_ITM_TABLE;
	
	
	public CarterveSelectSingle(Connection conn, CarterveInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.CART_RESERVE_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CarterveInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new CarterveWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(CarterveInfo recordInfo) {
		DaoJoinBuilder joinCart = new CarterveJoinCart(MAIN_TABLE);		
		return joinCart.build();
	}	
	
	
	
	@Override protected DaoResultParserV2<CarterveInfo> getResultParserHook() {
		return new DaoResultParserV2<CarterveInfo>() {		
			@Override public List<CarterveInfo> parseResult(CarterveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CarterveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CarterveInfo dataInfo = new CarterveInfo();
					
					dataInfo.codOwner = stmtResult.getLong(CarterveDbTableColumn.COL_COD_OWNER);
					dataInfo.codUser = stmtResult.getLong(CarterveDbTableColumn.COL_COD_USER);
					dataInfo.codStore = stmtResult.getLong(CarterveDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = stmtResult.getLong(CarterveDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = stmtResult.getLong(CarterveDbTableColumn.COL_COD_MATERIAL);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, CarterveDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, CarterveDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, CarterveDbTableColumn.COL_END_TIME);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, CarterveDbTableColumn.COL_END_TIME);		
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
