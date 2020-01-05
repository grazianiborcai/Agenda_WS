package br.com.mind5.business.cartItem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmtParamTranslator;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CartemUpdateSingle extends DaoStmtTemplate<CartemInfo> {
	private final String MAIN_TABLE = DaoDbTable.CART_ITM_TABLE;	
	
	
	public CartemUpdateSingle(Connection conn, CartemInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.UPDATE;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CartemInfo recordInfo) {		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new CartemWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoStmtParamTranslator<CartemInfo> getParamTranslatorHook() {
		return new DaoStmtParamTranslator<CartemInfo>() {		
			@Override public PreparedStatement translateStmtParam(PreparedStatement stmt, CartemInfo recordInfo) throws SQLException {					
				int i = 1;
				
				stmt = DaoFormatter.localTimeToStmt(stmt, i++, recordInfo.endTime);
				stmt.setInt(i++, recordInfo.quantity);
				stmt = DaoFormatter.localDateTimeToStmt(stmt, i++, recordInfo.createdOn);			
				
				return stmt;
			}		
		};
	}
}
