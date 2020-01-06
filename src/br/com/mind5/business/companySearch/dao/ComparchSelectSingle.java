package br.com.mind5.business.companySearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class ComparchSelectSingle extends DaoStmtTemplate<ComparchInfo> {
	private final String MAIN_TABLE = DaoDbTable.COMP_TABLE;
	
	
	public ComparchSelectSingle(Connection conn, ComparchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.COMP_SEARCH_VIEW;
	}		
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, ComparchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new ComparchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
		
	@Override protected DaoResultParserV2<ComparchInfo> getResultParserHook() {
		return new DaoResultParserV2<ComparchInfo>() {
			@Override public List<ComparchInfo> parseResult(ComparchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {				
				List<ComparchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					ComparchInfo dataInfo = new ComparchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(ComparchDbTableColumn.COL_COD_OWNER);
					dataInfo.codCompany = stmtResult.getLong(ComparchDbTableColumn.COL_COD_COMPANY);
					dataInfo.cnpj = stmtResult.getString(ComparchDbTableColumn.COL_CNPJ);		
					dataInfo.email = stmtResult.getString(ComparchDbTableColumn.COL_EMAIL);						
					dataInfo.recordMode = stmtResult.getString(ComparchDbTableColumn.COL_RECORD_MODE);
					dataInfo.codEntityCateg = stmtResult.getString(ComparchDbTableColumn.COL_COD_ENTITY_CATEG);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, ComparchDbTableColumn.COL_COD_SNAPSHOT);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
