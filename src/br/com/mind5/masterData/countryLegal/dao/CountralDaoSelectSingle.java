package br.com.mind5.masterData.countryLegal.dao;

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
import br.com.mind5.masterData.countryLegal.info.CountralInfo;

public final class CountralDaoSelectSingle extends DaoStmtTemplate<CountralInfo> {
	private final String MAIN_TABLE = DaoDbTable.COUNTRY_LEGAL_TABLE;
	
	
	public CountralDaoSelectSingle(Connection conn, CountralInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CountralInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new CountralDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<CountralInfo> getResultParserHook() {
		return new DaoResultParser<CountralInfo>() {
			@Override public List<CountralInfo> parseResult(CountralInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CountralInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					CountralInfo dataInfo = new CountralInfo();
					
					dataInfo.codCountry = stmtResult.getString(CountralDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.recordMode = stmtResult.getString(CountralDaoDbTableColumn.COL_RECORD_MODE);
					
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
