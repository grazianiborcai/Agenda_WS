package br.com.mind5.webhook.pagarmeHook.dao;

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
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;

public final class PagookDaoSelectSingle extends DaoStmtTemplate<PagookInfo> {
	private final String MAIN_TABLE = DaoDbTable.WEBHOOK_PAGARME_TABLE;
	
	
	public PagookDaoSelectSingle(Connection conn, PagookInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PagookInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull       = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PagookDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<PagookInfo> getResultParserHook() {
		return new DaoResultParser<PagookInfo>() {
			@Override public List<PagookInfo> parseResult(PagookInfo redcordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PagookInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PagookInfo dataInfo = new PagookInfo();
					
					dataInfo.codOwner        = DaoFormatter.sqlToLong(stmtResult, PagookDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codPayOrder     = DaoFormatter.sqlToLong(stmtResult, PagookDaoDbTableColumn.COL_COD_PAY_ORDER);
					dataInfo.codPayOrderItem = DaoFormatter.sqlToLong(stmtResult, PagookDaoDbTableColumn.COL_COD_PAY_ORDER_ITEM);
					dataInfo.createdOn       = DaoFormatter.sqlToLocalDateTime(stmtResult, PagookDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.type           = stmtResult.getString(PagookDaoDbTableColumn.COL_EVENT_WEBHOOK);
					dataInfo.id              = stmtResult.getString(PagookDaoDbTableColumn.COL_ID_WEBHOOK);
					dataInfo.lastChanged     = DaoFormatter.sqlToLocalDateTime(stmtResult, PagookDaoDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
		}
		};
	}
}
