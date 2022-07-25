package br.com.mind5.masterData.userCategory.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.userCategory.info.UseregInfo;

public final class UseregDaoSelectSingle extends DaoStmtTemplate<UseregInfo> {
	private final String MAIN_TABLE = DaoDbTable.USER_CATEG_TABLE;
	
	
	public UseregDaoSelectSingle(Connection conn, UseregInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, UseregInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new UseregDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(UseregInfo recordInfo) {
		DaoJoinBuilder joinText = new UseregDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<UseregInfo> getResultParserHook() {
		return new DaoResultParser<UseregInfo>() {
			@Override public List<UseregInfo> parseResult(UseregInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<UseregInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					UseregInfo dataInfo = new UseregInfo();
					
					dataInfo.codUserCategory = DaoFormatter.sqlToChar(stmtResult, UseregDaoDbTableColumn.COL_COD_USER_CATEG);
					dataInfo.txtUserCategory = stmtResult.getString(UseregDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(UseregDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
