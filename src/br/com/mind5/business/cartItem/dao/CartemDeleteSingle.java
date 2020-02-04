package br.com.mind5.business.cartItem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CartemDeleteSingle extends DaoStmtTemplate<CartemInfo> {
	private final String MAIN_TABLE = DaoDbTable.CART_ITM_TABLE;	
	
	
	public CartemDeleteSingle(Connection conn, CartemInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.HARD_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CartemInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new CartemWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<CartemInfo> getResultParserHook() {
		return new DaoResultParser<CartemInfo>() {
			@Override public List<CartemInfo> parseResult(CartemInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CartemInfo> finalResult = new ArrayList<>();
				CartemInfo emptyInfo = new CartemInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
