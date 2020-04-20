package br.com.mind5.masterData.materialCategory.dao;

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
import br.com.mind5.masterData.materialCategory.info.MategInfo;

public final class DaoMategSelectSingle extends DaoStmtTemplate<MategInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_CATEG_TABLE;
	
	
	public DaoMategSelectSingle(Connection conn, MategInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MategInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoMategWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(MategInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoMategJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<MategInfo> getResultParserHook() {
		return new DaoResultParser<MategInfo>() {
			@Override public List<MategInfo> parseResult(MategInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MategInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MategInfo dataInfo = new MategInfo();
					
					dataInfo.codMatCateg = stmtResult.getInt(DaoMategDbTableColumn.COL_COD_MAT_CATEG);
					dataInfo.txtMatCateg = stmtResult.getString(DaoMategDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoMategDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
