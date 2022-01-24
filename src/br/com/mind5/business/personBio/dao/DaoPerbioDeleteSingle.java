package br.com.mind5.business.personBio.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoPerbioDeleteSingle extends DaoStmtTemplate<PerbioInfo> {
	private final String MAIN_TABLE = DaoDbTable.PERSON_BIO_TABLE;	
	
	
	public DaoPerbioDeleteSingle(Connection conn, PerbioInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);	
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PerbioInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new DaoPerbioWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<PerbioInfo> getResultParserHook() {
		return new DaoResultParser<PerbioInfo>() {
			@Override public List<PerbioInfo> parseResult(PerbioInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PerbioInfo> finalResult = new ArrayList<>();
				PerbioInfo emptyInfo = new PerbioInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
