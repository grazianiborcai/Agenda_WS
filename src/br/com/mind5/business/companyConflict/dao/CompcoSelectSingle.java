package br.com.mind5.business.companyConflict.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CompcoSelectSingle extends DaoStmtTemplate<CompcoInfo> {
	private final String MAIN_TABLE = DaoDbTable.COMP_TABLE;
	
	
	public CompcoSelectSingle(Connection conn, CompcoInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.COMP_CONFLICT_VIEW;
	}		
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CompcoInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new CompcoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
		
	@Override protected DaoResultParserV2<CompcoInfo> getResultParserHook() {
		return new DaoResultParserV2<CompcoInfo>() {
			@Override public List<CompcoInfo> parseResult(CompcoInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {				
				List<CompcoInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CompcoInfo dataInfo = new CompcoInfo();
					
					dataInfo.codOwner = stmtResult.getLong(CompcoDbTableColumn.COL_COD_OWNER);
					dataInfo.codCompany = stmtResult.getLong(CompcoDbTableColumn.COL_COD_COMPANY);
					dataInfo.cnpj = stmtResult.getString(CompcoDbTableColumn.COL_CNPJ);		
					dataInfo.email = stmtResult.getString(CompcoDbTableColumn.COL_EMAIL);						
					dataInfo.recordMode = stmtResult.getString(CompcoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codEntityCateg = stmtResult.getString(CompcoDbTableColumn.COL_COD_ENTITY_CATEG);			
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
