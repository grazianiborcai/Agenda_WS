package br.com.mind5.masterData.feeCategory.dao;

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
import br.com.mind5.masterData.feeCategory.info.FeecatInfo;

public final class DaoFeecatSelectSingle extends DaoStmtTemplate<FeecatInfo> {
	private final String MAIN_TABLE = DaoDbTable.FEE_CATEG_TABLE;
	
	
	public DaoFeecatSelectSingle(Connection conn, FeecatInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FeecatInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoFeecatWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(FeecatInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoFeecatJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<FeecatInfo> getResultParserHook() {
		return new DaoResultParser<FeecatInfo>() {
			@Override public List<FeecatInfo> parseResult(FeecatInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FeecatInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					FeecatInfo dataInfo = new FeecatInfo();
					
					dataInfo.codFeeCateg = DaoFormatter.sqlToChar(stmtResult, DaoFeecatDbTableColumn.COL_COD_FEE_CATEG);
					dataInfo.txtFeeCateg = stmtResult.getString(DaoFeecatDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoFeecatDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
