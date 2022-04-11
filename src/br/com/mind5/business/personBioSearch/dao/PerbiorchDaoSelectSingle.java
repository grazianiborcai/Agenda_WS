package br.com.mind5.business.personBioSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBioSearch.info.PerbiorchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PerbiorchDaoSelectSingle extends DaoStmtTemplate<PerbiorchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PERSON_BIO_TABLE;
	
	
	public PerbiorchDaoSelectSingle(Connection conn, PerbiorchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PERSON_BIO_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PerbiorchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PerbiorchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<PerbiorchInfo> getResultParserHook() {
		return new DaoResultParser<PerbiorchInfo>() {		
			@Override public List<PerbiorchInfo> parseResult(PerbiorchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PerbiorchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PerbiorchInfo dataInfo = new PerbiorchInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, PerbiorchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, PerbiorchDaoDbTableColumn.COL_COD_PERSON);
					dataInfo.codLanguage = stmtResult.getString(PerbiorchDaoDbTableColumn.COL_COD_LANGUAGE);									
					dataInfo.recordMode = stmtResult.getString(PerbiorchDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, PerbiorchDaoDbTableColumn.COL_COD_SNAPSHOT);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
