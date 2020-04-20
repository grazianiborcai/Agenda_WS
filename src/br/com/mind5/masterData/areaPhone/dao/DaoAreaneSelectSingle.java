package br.com.mind5.masterData.areaPhone.dao;

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
import br.com.mind5.masterData.areaPhone.info.AreaneInfo;

public final class DaoAreaneSelectSingle extends DaoStmtTemplate<AreaneInfo> {
	private final String MAIN_TABLE = DaoDbTable.AREA_PHONE_TABLE;
	
	
	public DaoAreaneSelectSingle(Connection conn, AreaneInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, AreaneInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoAreaneWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(AreaneInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoAreaneJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<AreaneInfo> getResultParserHook() {
		return new DaoResultParser<AreaneInfo>() {
			@Override public List<AreaneInfo> parseResult(AreaneInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<AreaneInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					AreaneInfo dataInfo = new AreaneInfo();
					
					dataInfo.codCountryPhone = stmtResult.getInt(DaoAreaneDbTableColumn.COL_COD_COUNTRY_PHONE);
					dataInfo.codArea = stmtResult.getString(DaoAreaneDbTableColumn.COL_COD_AREA_PHONE);
					dataInfo.txtArea = stmtResult.getString(DaoAreaneDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoAreaneDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
