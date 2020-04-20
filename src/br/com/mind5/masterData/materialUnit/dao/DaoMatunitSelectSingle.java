package br.com.mind5.masterData.materialUnit.dao;

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
import br.com.mind5.masterData.materialUnit.info.MatunitInfo;

public final class DaoMatunitSelectSingle extends DaoStmtTemplate<MatunitInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_UNIT_TABLE;
	
	
	public DaoMatunitSelectSingle(Connection conn, MatunitInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatunitInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoMatunitWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(MatunitInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoMatunitJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<MatunitInfo> getResultParserHook() {
		return new DaoResultParser<MatunitInfo>() {
			@Override public List<MatunitInfo> parseResult(MatunitInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatunitInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MatunitInfo dataInfo = new MatunitInfo();
					
					dataInfo.codUnit = stmtResult.getString(DaoMatunitDbTableColumn.COL_COD_UNIT);
					dataInfo.txtUnit = stmtResult.getString(DaoMatunitDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoMatunitDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
