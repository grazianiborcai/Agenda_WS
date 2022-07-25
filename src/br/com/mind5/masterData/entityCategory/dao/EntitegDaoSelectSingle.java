package br.com.mind5.masterData.entityCategory.dao;

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
import br.com.mind5.masterData.entityCategory.info.EntitegInfo;

public final class EntitegDaoSelectSingle extends DaoStmtTemplate<EntitegInfo> {
	private final String MAIN_TABLE = DaoDbTable.ENTITY_CATEG_TABLE;
	
	
	public EntitegDaoSelectSingle(Connection conn, EntitegInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EntitegInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new EntitegDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(EntitegInfo recordInfo) {
		DaoJoinBuilder joinText = new EntitegDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<EntitegInfo> getResultParserHook() {
		return new DaoResultParser<EntitegInfo>() {
			@Override public List<EntitegInfo> parseResult(EntitegInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EntitegInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					EntitegInfo dataInfo = new EntitegInfo();
					
					dataInfo.codEntityCateg = stmtResult.getString(EntitegDaoDbTableColumn.COL_COD_ENTITY_CATEG);
					dataInfo.txtEntityCateg = stmtResult.getString(EntitegDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(EntitegDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
