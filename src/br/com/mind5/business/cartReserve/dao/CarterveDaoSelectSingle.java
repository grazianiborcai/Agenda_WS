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
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CarterveDaoSelectSingle extends DaoStmtTemplate<CarterveInfo> {
	private final String MAIN_TABLE = DaoDbTable.CART_ITM_TABLE;
	
	
	public CarterveDaoSelectSingle(Connection conn, CarterveInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new CarterveDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(CarterveInfo recordInfo) {
		DaoJoinBuilder joinCart = new CarterveDaoJoinCart(MAIN_TABLE);		
		return joinCart.build();
	}	
	
	
	
	@Override protected DaoResultParser<CarterveInfo> getResultParserHook() {
		return new DaoResultParser<CarterveInfo>() {		
			@Override public List<CarterveInfo> parseResult(CarterveInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CarterveInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CarterveInfo dataInfo = new CarterveInfo();
					
					dataInfo.codOwner = stmtResult.getLong(CarterveDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codUser = stmtResult.getLong(CarterveDaoDbTableColumn.COL_COD_USER);
					dataInfo.codStore = stmtResult.getLong(CarterveDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = stmtResult.getLong(CarterveDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = stmtResult.getLong(CarterveDaoDbTableColumn.COL_COD_MATERIAL);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, CarterveDaoDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, CarterveDaoDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, CarterveDaoDbTableColumn.COL_END_TIME);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, CarterveDaoDbTableColumn.COL_LAST_CHANGED);		
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
