package br.com.mind5.business.materialStore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoMatoreDeleteSingle extends DaoStmtTemplate<MatoreInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_STORE_TABLE;
	
	
	public DaoMatoreDeleteSingle(Connection conn, MatoreInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatoreInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;			
		
		DaoStmtWhere whereClause = new DaoMatoreWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
		
	
		
	@Override protected DaoResultParser<MatoreInfo> getResultParserHook() {
		return new DaoResultParser<MatoreInfo>() {
			@Override public List<MatoreInfo> parseResult(MatoreInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatoreInfo> finalResult = new ArrayList<>();
				MatoreInfo emptyInfo = new MatoreInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
