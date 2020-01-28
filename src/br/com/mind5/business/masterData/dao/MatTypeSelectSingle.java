package br.com.mind5.business.masterData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.MatTypeInfo;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MatTypeSelectSingle extends DaoStmtTemplate<MatTypeInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_TYPE_TABLE;
	
	
	public MatTypeSelectSingle(Connection conn, MatTypeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatTypeInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new MatTypeWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(MatTypeInfo recordInfo) {
		DaoJoinBuilder joinText = new MatTypeJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParserV2<MatTypeInfo> getResultParserHook() {
		return new DaoResultParserV2<MatTypeInfo>() {
			@Override public List<MatTypeInfo> parseResult(MatTypeInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatTypeInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MatTypeInfo dataInfo = new MatTypeInfo();
					
					dataInfo.codType = stmtResult.getInt(MasterDataDbTableColumn.COL_COD_MAT_TYPE);
					dataInfo.txtType = stmtResult.getString(MasterDataDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(MasterDataDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
