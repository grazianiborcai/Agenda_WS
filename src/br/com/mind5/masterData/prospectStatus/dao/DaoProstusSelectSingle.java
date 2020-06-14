package br.com.mind5.masterData.prospectStatus.dao;

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
import br.com.mind5.masterData.prospectStatus.info.ProstusInfo;

public final class DaoProstusSelectSingle extends DaoStmtTemplate<ProstusInfo> {
	private final String MAIN_TABLE = DaoDbTable.PROSPECT_STATUS_TABLE;
	
	
	public DaoProstusSelectSingle(Connection conn, ProstusInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, ProstusInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoProstusWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(ProstusInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoProstusJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<ProstusInfo> getResultParserHook() {
		return new DaoResultParser<ProstusInfo>() {
			@Override public List<ProstusInfo> parseResult(ProstusInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<ProstusInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					ProstusInfo dataInfo = new ProstusInfo();
					
					dataInfo.codProspectStatus = stmtResult.getString(DaoProstusDbTableColumn.COL_COD_PROSPECT_STATUS);
					dataInfo.txtProspectStatus = stmtResult.getString(DaoProstusDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoProstusDbTableColumn.COL_COD_LANGUAGE);		
					
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
