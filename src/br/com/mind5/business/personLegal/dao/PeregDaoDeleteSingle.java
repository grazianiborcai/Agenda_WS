package br.com.mind5.business.personLegal.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PeregDaoDeleteSingle extends DaoStmtTemplate<PeregInfo> {
	private final String MAIN_TABLE = DaoDbTable.LEGAL_PERSON_TABLE;	
	
	
	public PeregDaoDeleteSingle(Connection conn, PeregInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PeregInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new PeregDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<PeregInfo> getResultParserHook() {
		return new DaoResultParser<PeregInfo>() {
			@Override public List<PeregInfo> parseResult(PeregInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PeregInfo> finalResult = new ArrayList<>();
				PeregInfo emptyInfo = new PeregInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
