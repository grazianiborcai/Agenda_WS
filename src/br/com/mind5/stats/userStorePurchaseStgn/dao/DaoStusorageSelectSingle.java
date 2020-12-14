package br.com.mind5.stats.userStorePurchaseStgn.dao;

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
import br.com.mind5.stats.userStorePurchaseStgn.info.StusorageInfo;

public final class DaoStusorageSelectSingle extends DaoStmtTemplate<StusorageInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_USER_STORE_STGN_TABLE;	
	
	
	public DaoStusorageSelectSingle(Connection conn, StusorageInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StusorageInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoStusorageWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StusorageInfo> getResultParserHook() {
		return new DaoResultParser<StusorageInfo>() {
			@Override public List<StusorageInfo> parseResult(StusorageInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StusorageInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StusorageInfo dataInfo = new StusorageInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoStusorageDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoStusorageDbTableColumn.COL_COD_STORE);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoStusorageDbTableColumn.COL_COD_USER);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoStusorageDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
