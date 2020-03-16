package br.com.mind5.message.sysMessage.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.message.sysMessage.info.SymsgInfo;

public final class SymsgSelectSingle extends DaoStmtTemplate<SymsgInfo> {
	private final String MAIN_TABLE = DaoDbTable.SYS_MESSAGE_TABLE;	
	
	
	public SymsgSelectSingle(Connection conn, SymsgInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SymsgInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();		
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new SymsgWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
		
	@Override protected DaoResultParser<SymsgInfo> getResultParserHook() {
		return new DaoResultParser<SymsgInfo>() {
			@Override public List<SymsgInfo> parseResult(SymsgInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SymsgInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SymsgInfo dataInfo = new SymsgInfo();
					
					dataInfo.codMsg = DaoFormatter.sqlToInt(stmtResult, SymsgDbTableColumn.COL_COD_MESSAGE);
					dataInfo.txtMsg = stmtResult.getString(SymsgDbTableColumn.COL_MESSAGE);
					dataInfo.codLanguage = stmtResult.getString(SymsgDbTableColumn.COL_COD_LANGUAGE);
					
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
