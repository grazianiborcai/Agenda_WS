package br.com.mind5.masterData.dayParting.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.dayParting.info.DaypartInfo;

public final class DaypartDaoSelectSingle extends DaoStmtTemplate<DaypartInfo> {
	private final String MAIN_TABLE = DaoDbTable.DAYPART_TABLE;
	
	
	public DaypartDaoSelectSingle(Connection conn, DaypartInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, DaypartInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaypartDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(DaypartInfo recordInfo) {
		DaoJoinBuilder joinText = new DaypartDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<DaypartInfo> getResultParserHook() {
		return new DaoResultParser<DaypartInfo>() {
			@Override public List<DaypartInfo> parseResult(DaypartInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<DaypartInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					DaypartInfo dataInfo = new DaypartInfo();
					
					dataInfo.codDaypart = stmtResult.getInt(DaypartDaoDbTableColumn.COL_COD_DAYPART);
					dataInfo.txtDaypart = stmtResult.getString(DaypartDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaypartDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
