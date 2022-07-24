package br.com.mind5.masterData.businessArea.dao;

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
import br.com.mind5.masterData.businessArea.info.BusareaInfo;

public final class BusareaDaoSelectSingle extends DaoStmtTemplate<BusareaInfo> {
	private final String MAIN_TABLE = DaoDbTable.BUSINESS_AREA_TABLE;
	
	
	public BusareaDaoSelectSingle(Connection conn, BusareaInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, BusareaInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new BusareaDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(BusareaInfo recordInfo) {
		DaoJoinBuilder joinText = new BusareaDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<BusareaInfo> getResultParserHook() {
		return new DaoResultParser<BusareaInfo>() {
			@Override public List<BusareaInfo> parseResult(BusareaInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<BusareaInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					BusareaInfo dataInfo = new BusareaInfo();
					
					dataInfo.codBusiness = stmtResult.getInt(BusareaDaoDaoDbTableColumn.COL_COD_BUSINESS);
					dataInfo.txtBusiness = stmtResult.getString(BusareaDaoDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(BusareaDaoDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
