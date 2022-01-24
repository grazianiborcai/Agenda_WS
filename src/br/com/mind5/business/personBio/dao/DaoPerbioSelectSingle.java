package br.com.mind5.business.personBio.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personBio.info.PerbioInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoPerbioSelectSingle extends DaoStmtTemplate<PerbioInfo> {
	private final String MAIN_TABLE = DaoDbTable.PERSON_BIO_TABLE;
	
	
	public DaoPerbioSelectSingle(Connection conn, PerbioInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PerbioInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoPerbioWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<PerbioInfo> getResultParserHook() {
		return new DaoResultParser<PerbioInfo>() {
			@Override public List<PerbioInfo> parseResult(PerbioInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PerbioInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PerbioInfo dataInfo = new PerbioInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoPerbioDbTableColumn.COL_COD_OWNER);
					dataInfo.codPerson = stmtResult.getLong(DaoPerbioDbTableColumn.COL_COD_PERSON);
					dataInfo.codLanguage = stmtResult.getString(DaoPerbioDbTableColumn.COL_COD_LANGUAGE);
					dataInfo.txtBio = stmtResult.getString(DaoPerbioDbTableColumn.COL_BIO_TEXT);
					dataInfo.recordMode = stmtResult.getString(DaoPerbioDbTableColumn.COL_RECORD_MODE);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoPerbioDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoPerbioDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoPerbioDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoPerbioDbTableColumn.COL_CREATED_BY);
					dataInfo.codSnapshot = stmtResult.getLong(DaoPerbioDbTableColumn.COL_COD_SNAPSHOT);
					
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
