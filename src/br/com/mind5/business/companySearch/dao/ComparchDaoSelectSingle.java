package br.com.mind5.business.companySearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class ComparchDaoSelectSingle extends DaoStmtTemplate<ComparchInfo> {
	private final String MAIN_TABLE = DaoDbTable.COMP_TABLE;
	
	
	public ComparchDaoSelectSingle(Connection conn, ComparchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.COMP_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}	
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, ComparchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new ComparchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
		
	@Override protected DaoResultParser<ComparchInfo> getResultParserHook() {
		return new DaoResultParser<ComparchInfo>() {
			@Override public List<ComparchInfo> parseResult(ComparchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {				
				List<ComparchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					ComparchInfo dataInfo = new ComparchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(ComparchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codCompany = stmtResult.getLong(ComparchDaoDbTableColumn.COL_COD_COMPANY);
					dataInfo.cnpj = stmtResult.getString(ComparchDaoDbTableColumn.COL_CNPJ);		
					dataInfo.email = stmtResult.getString(ComparchDaoDbTableColumn.COL_EMAIL);						
					dataInfo.recordMode = stmtResult.getString(ComparchDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codEntityCateg = stmtResult.getString(ComparchDaoDbTableColumn.COL_COD_ENTITY_CATEG);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, ComparchDaoDbTableColumn.COL_COD_SNAPSHOT);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
