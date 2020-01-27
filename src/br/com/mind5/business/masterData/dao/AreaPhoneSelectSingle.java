package br.com.mind5.business.masterData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.AreaPhoneInfo;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class AreaPhoneSelectSingle extends DaoStmtTemplate<AreaPhoneInfo> {
	private final String MAIN_TABLE = DaoDbTable.AREA_PHONE_TABLE;
	
	
	public AreaPhoneSelectSingle(Connection conn, AreaPhoneInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, AreaPhoneInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new AreaPhoneWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(AreaPhoneInfo recordInfo) {
		DaoJoinBuilder joinText = new AreaPhoneJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParserV2<AreaPhoneInfo> getResultParserHook() {
		return new DaoResultParserV2<AreaPhoneInfo>() {
			@Override public List<AreaPhoneInfo> parseResult(AreaPhoneInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<AreaPhoneInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					AreaPhoneInfo dataInfo = new AreaPhoneInfo();
					
					dataInfo.codCountryPhone = stmtResult.getInt(MasterDataDbTableColumn.COL_COD_COUNTRY_PHONE);
					dataInfo.codArea = stmtResult.getString(MasterDataDbTableColumn.COL_COD_AREA_PHONE);
					dataInfo.txtArea = stmtResult.getString(MasterDataDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(MasterDataDbTableColumn.COL_COD_LANGUAGE);		
					
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
