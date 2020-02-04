package br.com.mind5.business.masterData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MatGroupSelectSingle extends DaoStmtTemplate<MatGroupInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_GROUP_TABLE;
	private final String RT_TEXT = DaoDbTable.MAT_GROUP_TEXT_TABLE;
	private final String RT_BUSINESS_TEXT = DaoDbTable.BUSINESS_AREA_TEXT_TABLE;
	
	
	public MatGroupSelectSingle(Connection conn, MatGroupInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatGroupInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new MatGroupWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook(MatGroupInfo recordInfo) {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinText = new MatGroupJoinTxt(MAIN_TABLE);		
		joins.add(joinText.build());
		
		DaoJoinBuilder joinBusiness = new MatGroupJoinBusiness(MAIN_TABLE, recordInfo.codLanguage);		
		joins.add(joinBusiness.build());
		
		return joins;
	}
	
	
	
	@Override protected DaoResultParser<MatGroupInfo> getResultParserHook() {
		return new DaoResultParser<MatGroupInfo>() {
			private final String GROUP_TEXT_COL = RT_TEXT + "." + MasterDataDbTableColumn.COL_NAME;
			private final String BUSINESS_TEXT_COL = RT_BUSINESS_TEXT + "." + MasterDataDbTableColumn.COL_NAME;
			
			@Override public List<MatGroupInfo> parseResult(MatGroupInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatGroupInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MatGroupInfo dataInfo = new MatGroupInfo();
					
					dataInfo.codGroup = stmtResult.getInt(MasterDataDbTableColumn.COL_COD_MAT_GROUP);				
					dataInfo.txtGroup = stmtResult.getString(GROUP_TEXT_COL);
					dataInfo.codBusiness = stmtResult.getInt(MasterDataDbTableColumn.COL_COD_BUSINESS);
					dataInfo.txtBusiness = stmtResult.getString(BUSINESS_TEXT_COL);
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
