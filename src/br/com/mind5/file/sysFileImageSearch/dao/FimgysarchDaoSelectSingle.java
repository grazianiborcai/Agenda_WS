package br.com.mind5.file.sysFileImageSearch.dao;

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
import br.com.mind5.file.sysFileImageSearch.info.FimgysarchInfo;

public final class FimgysarchDaoSelectSingle extends DaoStmtTemplate<FimgysarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.SYS_FILE_IMG_TABLE;
	
	
	public FimgysarchDaoSelectSingle(Connection conn, FimgysarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.SYS_FILE_IMG_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FimgysarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new FimgysarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<FimgysarchInfo> getResultParserHook() {
		return new DaoResultParser<FimgysarchInfo>() {
			@Override public List<FimgysarchInfo> parseResult(FimgysarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FimgysarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					FimgysarchInfo dataInfo = new FimgysarchInfo();
					
					dataInfo.codFileImg = DaoFormatter.sqlToLong(stmtResult, FimgysarchDaoDbTableColumn.COL_COD_FILE_IMG);
					dataInfo.recordMode = stmtResult.getString(FimgysarchDaoDbTableColumn.COL_RECORD_MODE);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
