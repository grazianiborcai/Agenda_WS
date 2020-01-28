package br.com.mind5.business.masterData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class FeeCategSelectSingle extends DaoStmtTemplate<FeeCategInfo> {
	private final String MAIN_TABLE = DaoDbTable.FEE_CATEG_TABLE;
	
	
	public FeeCategSelectSingle(Connection conn, FeeCategInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FeeCategInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new FeeCategWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(FeeCategInfo recordInfo) {
		DaoJoinBuilder joinText = new FeeCategJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParserV2<FeeCategInfo> getResultParserHook() {
		return new DaoResultParserV2<FeeCategInfo>() {
			@Override public List<FeeCategInfo> parseResult(FeeCategInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FeeCategInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					FeeCategInfo dataInfo = new FeeCategInfo();
					
					dataInfo.codFeeCateg = DaoFormatter.sqlToChar(stmtResult, MasterDataDbTableColumn.COL_COD_FEE_CATEG);
					dataInfo.txtFeeCateg = stmtResult.getString(MasterDataDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(MasterDataDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
