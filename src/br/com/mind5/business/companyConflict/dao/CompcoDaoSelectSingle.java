package br.com.mind5.business.companyConflict.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CompcoDaoSelectSingle extends DaoStmtTemplate<CompcoInfo> {
	private final String MAIN_TABLE = DaoDbTable.COMP_TABLE;
	
	
	public CompcoDaoSelectSingle(Connection conn, CompcoInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.COMP_CONFLICT_VIEW;
	}		
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CompcoInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new CompcoDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
		
	@Override protected DaoResultParser<CompcoInfo> getResultParserHook() {
		return new DaoResultParser<CompcoInfo>() {
			@Override public List<CompcoInfo> parseResult(CompcoInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {				
				List<CompcoInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CompcoInfo dataInfo = new CompcoInfo();
					
					dataInfo.codOwner = stmtResult.getLong(CompcoDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codCompany = stmtResult.getLong(CompcoDaoDbTableColumn.COL_COD_COMPANY);
					dataInfo.cnpj = stmtResult.getString(CompcoDaoDbTableColumn.COL_CNPJ);		
					dataInfo.email = stmtResult.getString(CompcoDaoDbTableColumn.COL_EMAIL);						
					dataInfo.recordMode = stmtResult.getString(CompcoDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codEntityCateg = stmtResult.getString(CompcoDaoDbTableColumn.COL_COD_ENTITY_CATEG);			
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
