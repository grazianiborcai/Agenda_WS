package br.com.mind5.masterData.cartItemCategory.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.cartItemCategory.info.CaritegInfo;

public final class CaritegDaoSelectSingle extends DaoStmtTemplate<CaritegInfo> {
	private final String MAIN_TABLE = DaoDbTable.CART_ITM_CATEG_TABLE;
	
	
	public CaritegDaoSelectSingle(Connection conn, CaritegInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CaritegInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new CaritegDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<CaritegInfo> getResultParserHook() {
		return new DaoResultParser<CaritegInfo>() {
			@Override public List<CaritegInfo> parseResult(CaritegInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CaritegInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					CaritegInfo dataInfo = new CaritegInfo();
					
					dataInfo.codItemCateg = DaoFormatter.sqlToChar(stmtResult, CaritegDaoDbTableColumn.COL_COD_ITEM_CATEG);
					dataInfo.txtItemCateg = stmtResult.getString(CaritegDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(CaritegDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
