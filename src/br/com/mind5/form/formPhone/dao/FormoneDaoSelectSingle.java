package br.com.mind5.form.formPhone.dao;

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
import br.com.mind5.form.formPhone.info.FormoneInfo;

public final class FormoneDaoSelectSingle extends DaoStmtTemplate<FormoneInfo> {
	private final String MAIN_TABLE = DaoDbTable.PHONE_FORM_TABLE;
	
	
	public FormoneDaoSelectSingle(Connection conn, FormoneInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FormoneInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new FormoneDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<FormoneInfo> getResultParserHook() {
		return new DaoResultParser<FormoneInfo>() {
			@Override public List<FormoneInfo> parseResult(FormoneInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FormoneInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					FormoneInfo dataInfo = new FormoneInfo();
					
					dataInfo.codCountry = stmtResult.getString(FormoneDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codForm = stmtResult.getString(FormoneDaoDbTableColumn.COL_COD_FORM);
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
