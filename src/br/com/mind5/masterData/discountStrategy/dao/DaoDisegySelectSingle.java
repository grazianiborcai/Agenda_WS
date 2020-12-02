package br.com.mind5.masterData.discountStrategy.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;

public final class DaoDisegySelectSingle extends DaoStmtTemplate<DisegyInfo> {
	private final String MAIN_TABLE = DaoDbTable.DISCOUNT_STRATEGY_TABLE;
	
	
	public DaoDisegySelectSingle(Connection conn, DisegyInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, DisegyInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoDisegyWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(DisegyInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoDisegyJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<DisegyInfo> getResultParserHook() {
		return new DaoResultParser<DisegyInfo>() {
			@Override public List<DisegyInfo> parseResult(DisegyInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<DisegyInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					DisegyInfo dataInfo = new DisegyInfo();
					
					dataInfo.codDiscountStrategy = stmtResult.getInt(DaoDisegyDbTableColumn.COL_COD_DISCOUNT_STRATEGY);
					dataInfo.txtDiscountStrategy = stmtResult.getString(DaoDisegyDbTableColumn.COL_NAME);
					dataInfo.descriptionDiscountStrategy = stmtResult.getString(DaoDisegyDbTableColumn.COL_DESCRIPTION);
					dataInfo.codLanguage = stmtResult.getString(DaoDisegyDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
