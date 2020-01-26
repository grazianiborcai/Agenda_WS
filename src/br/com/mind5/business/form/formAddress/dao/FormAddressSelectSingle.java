package br.com.mind5.business.form.formAddress.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class FormAddressSelectSingle extends DaoStmtTemplate<FormAddressInfo> {
	private final String MAIN_TABLE = DaoDbTable.ADDRESS_FORM_TABLE;
	
	
	public FormAddressSelectSingle(Connection conn, FormAddressInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FormAddressInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new FormAddressWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<FormAddressInfo> getResultParserHook() {
		return new DaoResultParserV2<FormAddressInfo>() {
			@Override public List<FormAddressInfo> parseResult(FormAddressInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FormAddressInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					FormAddressInfo dataInfo = new FormAddressInfo();
					
					dataInfo.codCountry = stmtResult.getString(FormAddressDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codForm = stmtResult.getString(FormAddressDbTableColumn.COL_COD_FORM);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
