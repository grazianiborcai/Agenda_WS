package br.com.mind5.business.cart.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cart.info.CartInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoCartSelectSingle extends DaoStmtTemplate<CartInfo> {
	private final String MAIN_TABLE = DaoDbTable.CART_HDR_TABLE;
	
	
	public DaoCartSelectSingle(Connection conn, CartInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CartInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoCartWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<CartInfo> getResultParserHook() {
		return new DaoResultParser<CartInfo>() {
			@Override public List<CartInfo> parseResult(CartInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {				
				List<CartInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CartInfo dataInfo = new CartInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoCartDbTableColumn.COL_COD_OWNER);	
					dataInfo.codUser = stmtResult.getLong(DaoCartDbTableColumn.COL_COD_USER);	
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoCartDbTableColumn.COL_LAST_CHANGED);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
