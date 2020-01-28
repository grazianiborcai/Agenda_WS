package br.com.mind5.message.emailBody.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmabodySelectSingle extends DaoStmtTemplate<EmabodyInfo> {
	private final String MAIN_TABLE = DaoDbTable.SYS_EMAIL_BODY_TABLE;	
	
	
	public EmabodySelectSingle(Connection conn, EmabodyInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmabodyInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new EmabodyWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<EmabodyInfo> getResultParserHook() {
		return new DaoResultParserV2<EmabodyInfo>() {
			@Override public List<EmabodyInfo> parseResult(EmabodyInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {	
				List<EmabodyInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					EmabodyInfo dataInfo = new EmabodyInfo();
					
					dataInfo.codBody = stmtResult.getString(EmabodyDbTableColumn.COL_COD_BODY);
					dataInfo.txtbody = stmtResult.getString(EmabodyDbTableColumn.COL_TXT_BODY);
					dataInfo.subject = stmtResult.getString(EmabodyDbTableColumn.COL_SUBJECT);
					dataInfo.codLanguage = stmtResult.getString(EmabodyDbTableColumn.COL_COD_LANGUAGE);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
