package br.com.mind5.business.personBioSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBioSnapshot.info.PerbionapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoPerbionapSelectSingle extends DaoStmtTemplate<PerbionapInfo> {
	private final String MAIN_TABLE = DaoDbTable.PERSON_BIO_SNAPSHOT_TABLE;
	
	
	public DaoPerbionapSelectSingle(Connection conn, PerbionapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PerbionapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoPerbionapWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<PerbionapInfo> getResultParserHook() {
		return new DaoResultParser<PerbionapInfo>() {
			@Override public List<PerbionapInfo> parseResult(PerbionapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PerbionapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PerbionapInfo dataInfo = new PerbionapInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoPerbionapDbTableColumn.COL_COD_OWNER);
					dataInfo.codPerson = stmtResult.getLong(DaoPerbionapDbTableColumn.COL_COD_PERSON);
					dataInfo.codLanguage = stmtResult.getString(DaoPerbionapDbTableColumn.COL_COD_LANGUAGE);
					dataInfo.txtBio = stmtResult.getString(DaoPerbionapDbTableColumn.COL_BIO_TEXT);
					dataInfo.recordMode = stmtResult.getString(DaoPerbionapDbTableColumn.COL_RECORD_MODE);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoPerbionapDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoPerbionapDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoPerbionapDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoPerbionapDbTableColumn.COL_CREATED_BY);
					dataInfo.codSnapshot = stmtResult.getLong(DaoPerbionapDbTableColumn.COL_COD_SNAPSHOT);
					
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
