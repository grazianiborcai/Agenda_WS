package br.com.mind5.masterData.fileDocTypeSearch.dao;

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
import br.com.mind5.masterData.fileDocTypeSearch.info.FidocarchInfo;

public final class FidocarchDaoSelectSingle extends DaoStmtTemplate<FidocarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.FILE_DOC_TYPE_TABLE;
	
	
	public FidocarchDaoSelectSingle(Connection conn, FidocarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.FILE_DOC_TYPE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FidocarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new FidocarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(FidocarchInfo recordInfo) {
		DaoJoinBuilder joinText = new FidocarchDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<FidocarchInfo> getResultParserHook() {
		return new DaoResultParser<FidocarchInfo>() {
			@Override public List<FidocarchInfo> parseResult(FidocarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FidocarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					FidocarchInfo dataInfo = new FidocarchInfo();
					
					dataInfo.codFileDocType = stmtResult.getString(FidocarchDaoDbTableColumn.COL_COD_FILE_DOC_TYPE);
					dataInfo.txtFileDocType = stmtResult.getString(FidocarchDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(FidocarchDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
