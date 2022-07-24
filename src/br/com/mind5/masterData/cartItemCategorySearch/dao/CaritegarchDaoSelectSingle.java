package br.com.mind5.masterData.cartItemCategorySearch.dao;

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
import br.com.mind5.masterData.cartItemCategorySearch.info.CaritegarchInfo;

public final class CaritegarchDaoSelectSingle extends DaoStmtTemplate<CaritegarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.CART_ITM_CATEG_TABLE;
	
	
	public CaritegarchDaoSelectSingle(Connection conn, CaritegarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.CART_ITM_CATEG_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CaritegarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new CaritegarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<CaritegarchInfo> getResultParserHook() {
		return new DaoResultParser<CaritegarchInfo>() {
			@Override public List<CaritegarchInfo> parseResult(CaritegarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CaritegarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					CaritegarchInfo dataInfo = new CaritegarchInfo();
					
					dataInfo.codItemCateg = DaoFormatter.sqlToChar(stmtResult, CaritegarchDaoDbTableColumn.COL_COD_ITEM_CATEG);
					dataInfo.txtItemCateg = stmtResult.getString(CaritegarchDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(CaritegarchDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
