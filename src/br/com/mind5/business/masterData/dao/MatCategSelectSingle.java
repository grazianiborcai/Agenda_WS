package br.com.mind5.business.masterData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MatCategSelectSingle extends DaoStmtTemplate<MatCategInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_CATEG_TABLE;
	
	
	public MatCategSelectSingle(Connection conn, MatCategInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatCategInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new MatCategWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(MatCategInfo recordInfo) {
		DaoJoinBuilder joinText = new MatCategJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParserV2<MatCategInfo> getResultParserHook() {
		return new DaoResultParserV2<MatCategInfo>() {
			@Override public List<MatCategInfo> parseResult(MatCategInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatCategInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MatCategInfo dataInfo = new MatCategInfo();
					
					dataInfo.codMatCateg = stmtResult.getInt(MasterDataDbTableColumn.COL_COD_MAT_CATEG);
					dataInfo.txtMatCateg = stmtResult.getString(MasterDataDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(MasterDataDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
