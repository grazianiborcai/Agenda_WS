package br.com.mind5.masterData.language.dao;

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
import br.com.mind5.masterData.language.info.LanguInfo;

public final class LanguDaoSelectSingle extends DaoStmtTemplate<LanguInfo> {
	private final String MAIN_TABLE = DaoDbTable.LANGUAGE_TABLE;	
	
	
	public LanguDaoSelectSingle(Connection conn, LanguInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, LanguInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new LanguDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<LanguInfo> getResultParserHook() {
		return new DaoResultParser<LanguInfo>() {
			@Override public List<LanguInfo> parseResult(LanguInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<LanguInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					LanguInfo dataInfo = new LanguInfo();
					
					dataInfo.codLanguage = stmtResult.getString(LanguDaoDbTableColumn.COL_COD_LANGUAGE);
					dataInfo.txtLanguage = stmtResult.getString(LanguDaoDbTableColumn.COL_NAME);	
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
