package br.com.mind5.masterData.petWeight.dao;

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
import br.com.mind5.masterData.petWeight.info.PeteightInfo;

public final class PeteightDaoSelectSingle extends DaoStmtTemplate<PeteightInfo> {
	private final String MAIN_TABLE = DaoDbTable.PET_WEIGHT_TABLE;
	
	
	public PeteightDaoSelectSingle(Connection conn, PeteightInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PeteightInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new PeteightDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(PeteightInfo recordInfo) {
		DaoJoinBuilder joinText = new PeteightDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}	
	
	
	
	@Override protected DaoResultParser<PeteightInfo> getResultParserHook() {
		return new DaoResultParser<PeteightInfo>() {
			@Override public List<PeteightInfo> parseResult(PeteightInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PeteightInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					PeteightInfo dataInfo = new PeteightInfo();
					
					dataInfo.codPeteight = DaoFormatter.sqlToInt(stmtResult, PeteightDaoDbTableColumn.COL_COD_PET_WEIGHT);
					dataInfo.txtPeteightKg = stmtResult.getString(PeteightDaoDbTableColumn.COL_NAME_KG);
					dataInfo.codLanguage = stmtResult.getString(PeteightDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
