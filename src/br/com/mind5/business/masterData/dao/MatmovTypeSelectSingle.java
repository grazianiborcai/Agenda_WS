package br.com.mind5.business.masterData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.MatmovTypeInfo;
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

public final class MatmovTypeSelectSingle extends DaoStmtTemplate<MatmovTypeInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_MOV_TYPE_TABLE;
	
	
	public MatmovTypeSelectSingle(Connection conn, MatmovTypeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatmovTypeInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new MatmovTypeWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(MatmovTypeInfo recordInfo) {
		DaoJoinBuilder joinText = new MatmovTypeJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParserV2<MatmovTypeInfo> getResultParserHook() {
		return new DaoResultParserV2<MatmovTypeInfo>() {
			@Override public List<MatmovTypeInfo> parseResult(MatmovTypeInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatmovTypeInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MatmovTypeInfo dataInfo = new MatmovTypeInfo();
					
					dataInfo.codMatmovType = DaoFormatter.sqlToChar(stmtResult, MasterDataDbTableColumn.COL_COD_MAT_MOV_TYPE);
					dataInfo.txtMatmovType = stmtResult.getString(MasterDataDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(MasterDataDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
