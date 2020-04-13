package br.com.mind5.form.formAddressSearch.dao;

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
import br.com.mind5.form.formAddressSearch.info.FormesarchInfo;

public final class DaoFormesarchSelectSingle extends DaoStmtTemplate<FormesarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.ADDRESS_FORM_TABLE;
	
	
	public DaoFormesarchSelectSingle(Connection conn, FormesarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.ADDRESS_FORM_SEARCH_VIEW;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FormesarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new DaoFormesarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<FormesarchInfo> getResultParserHook() {
		return new DaoResultParser<FormesarchInfo>() {
			@Override public List<FormesarchInfo> parseResult(FormesarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FormesarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					FormesarchInfo dataInfo = new FormesarchInfo();
					
					dataInfo.codCountry = stmtResult.getString(DaoFormesarchDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codForm = stmtResult.getString(DaoFormesarchDbTableColumn.COL_COD_FORM);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
