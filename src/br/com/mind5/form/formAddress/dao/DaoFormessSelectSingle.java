package br.com.mind5.form.formAddress.dao;

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
import br.com.mind5.form.formAddress.info.FormessInfo;

public final class DaoFormessSelectSingle extends DaoStmtTemplate<FormessInfo> {
	private final String MAIN_TABLE = DaoDbTable.ADDRESS_FORM_TABLE;
	
	
	public DaoFormessSelectSingle(Connection conn, FormessInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FormessInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoFormessWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<FormessInfo> getResultParserHook() {
		return new DaoResultParser<FormessInfo>() {
			@Override public List<FormessInfo> parseResult(FormessInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FormessInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					FormessInfo dataInfo = new FormessInfo();
					
					dataInfo.codCountry = stmtResult.getString(DaoFormessDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codForm = stmtResult.getString(DaoFormessDbTableColumn.COL_COD_FORM);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
