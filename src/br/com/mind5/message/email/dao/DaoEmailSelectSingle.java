package br.com.mind5.message.email.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.message.email.info.EmailInfo;

public final class DaoEmailSelectSingle extends DaoStmtTemplate<EmailInfo> {
	private final String MAIN_TABLE = DaoDbTable.SYS_EMAIL_TABLE;
	
	
	public DaoEmailSelectSingle(Connection conn, EmailInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmailInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoEmailWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
		
	@Override protected DaoResultParser<EmailInfo> getResultParserHook() {
		return new DaoResultParser<EmailInfo>() {
			@Override public List<EmailInfo> parseResult(EmailInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {	
				List<EmailInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					EmailInfo dataInfo = new EmailInfo();
					
					dataInfo.smtpHostname = stmtResult.getString(DaoEmailDbTableColumn.COL_SMTP_HOST_NAME);
					dataInfo.smtpPort = stmtResult.getInt(DaoEmailDbTableColumn.COL_SMTP_PORT);
					dataInfo.senderAddr = stmtResult.getString(DaoEmailDbTableColumn.COL_EMAIL_SENDER);
					dataInfo.senderPass = stmtResult.getString(DaoEmailDbTableColumn.COL_SENDER_PASSWORD);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
