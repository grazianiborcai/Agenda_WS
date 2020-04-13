package br.com.mind5.masterData.state.dao;

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
import br.com.mind5.masterData.state.info.StateInfo;

public final class DaoStateSelectSingle extends DaoStmtTemplate<StateInfo> {
	private final String MAIN_TABLE = DaoDbTable.STATE_TABLE;
	
	
	public DaoStateSelectSingle(Connection conn, StateInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StateInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoStateWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(StateInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoStateJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<StateInfo> getResultParserHook() {
		return new DaoResultParser<StateInfo>() {
			@Override public List<StateInfo> parseResult(StateInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StateInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					StateInfo dataInfo = new StateInfo();
					
					dataInfo.codCountry = stmtResult.getString(DaoStateDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codState = stmtResult.getString(DaoStateDbTableColumn.COL_STATE_PROVINCE);
					dataInfo.txtState = stmtResult.getString(DaoStateDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoStateDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
	
	
	
	@Override public void close() {
		super.close();
	}
}
