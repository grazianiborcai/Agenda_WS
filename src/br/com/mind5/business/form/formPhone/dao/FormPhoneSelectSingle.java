package br.com.mind5.business.form.formPhone.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.form.formPhone.info.FormPhoneInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class FormPhoneSelectSingle extends DaoStmtTemplate<FormPhoneInfo> {
	private final String MAIN_TABLE = DaoDbTable.PHONE_FORM_TABLE;
	
	
	public FormPhoneSelectSingle(Connection conn, FormPhoneInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FormPhoneInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new FormPhoneWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<FormPhoneInfo> getResultParserHook() {
		return new DaoResultParser<FormPhoneInfo>() {
			@Override public List<FormPhoneInfo> parseResult(FormPhoneInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FormPhoneInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					FormPhoneInfo dataInfo = new FormPhoneInfo();
					
					dataInfo.codCountry = stmtResult.getString(FormPhoneDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codForm = stmtResult.getString(FormPhoneDbTableColumn.COL_COD_FORM);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
