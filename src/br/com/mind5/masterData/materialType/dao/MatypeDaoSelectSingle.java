package br.com.mind5.masterData.materialType.dao;

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
import br.com.mind5.masterData.materialType.info.MatypeInfo;

public final class MatypeDaoSelectSingle extends DaoStmtTemplate<MatypeInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_TYPE_TABLE;
	
	
	public MatypeDaoSelectSingle(Connection conn, MatypeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatypeInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new MatypeDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(MatypeInfo recordInfo) {
		DaoJoinBuilder joinText = new MatypeDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<MatypeInfo> getResultParserHook() {
		return new DaoResultParser<MatypeInfo>() {
			@Override public List<MatypeInfo> parseResult(MatypeInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatypeInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MatypeInfo dataInfo = new MatypeInfo();
					
					dataInfo.codType = stmtResult.getInt(MatypeDaoDbTableColumn.COL_COD_MAT_TYPE);
					dataInfo.txtType = stmtResult.getString(MatypeDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(MatypeDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
