package br.com.mind5.business.materialText.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MatextDaoDeleteSingle extends DaoStmtTemplate<MatextInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_TEXT_TABLE;	
	
	
	public MatextDaoDeleteSingle(Connection conn, MatextInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);	
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatextInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new MatextDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<MatextInfo> getResultParserHook() {
		return new DaoResultParser<MatextInfo>() {
			@Override public List<MatextInfo> parseResult(MatextInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatextInfo> finalResult = new ArrayList<>();
				MatextInfo emptyInfo = new MatextInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
