package br.com.mind5.business.cartItem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.cartItem.info.CartemInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CartemDaoSelectSingle extends DaoStmtTemplate<CartemInfo> {	
	private final String MAIN_TABLE = DaoDbTable.CART_ITM_TABLE;
	
	
	public CartemDaoSelectSingle(Connection conn, CartemInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CartemInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new CartemDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
		
	
	
	@Override protected DaoResultParser<CartemInfo> getResultParserHook() {
		return new DaoResultParser<CartemInfo>() {
			@Override public List<CartemInfo> parseResult(CartemInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {					
				List<CartemInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CartemInfo dataInfo = new CartemInfo();
					
					dataInfo.codOwner = stmtResult.getLong(CartemDaoDbTableColumn.COL_COD_OWNER);	
					dataInfo.codUser = stmtResult.getLong(CartemDaoDbTableColumn.COL_COD_USER);
					dataInfo.quantity = stmtResult.getInt(CartemDaoDbTableColumn.COL_QUANTITY);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, CartemDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codEmployee = DaoFormatter.sqlToLong(stmtResult, CartemDaoDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = DaoFormatter.sqlToLong(stmtResult, CartemDaoDbTableColumn.COL_COD_MATERIAL);
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, CartemDaoDbTableColumn.COL_DATE);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, CartemDaoDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, CartemDaoDbTableColumn.COL_END_TIME);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, CartemDaoDbTableColumn.COL_CREATED_ON);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
