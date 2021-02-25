package br.com.mind5.stats.userOrderYearStgn.dao;

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
import br.com.mind5.stats.userOrderYearStgn.info.StusorygeInfo;

public final class DaoStusorygeSelectSingle extends DaoStmtTemplate<StusorygeInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_USER_ORDER_YEAR_STGN_TABLE;	
	
	
	public DaoStusorygeSelectSingle(Connection conn, StusorygeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StusorygeInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoStusorygeWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StusorygeInfo> getResultParserHook() {
		return new DaoResultParser<StusorygeInfo>() {
			@Override public List<StusorygeInfo> parseResult(StusorygeInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StusorygeInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StusorygeInfo dataInfo = new StusorygeInfo();
					
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoStusorygeDbTableColumn.COL_COD_USER);
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoStusorygeDbTableColumn.COL_COD_OWNER);
					dataInfo.postingYear = DaoFormatter.sqlToInt(stmtResult, DaoStusorygeDbTableColumn.COL_POSTING_YEAR);					
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoStusorygeDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
