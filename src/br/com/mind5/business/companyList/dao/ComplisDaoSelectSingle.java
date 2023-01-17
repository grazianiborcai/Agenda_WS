package br.com.mind5.business.companyList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class ComplisDaoSelectSingle extends DaoStmtTemplate<ComplisInfo> {
	private final String MAIN_TABLE = DaoDbTable.COMP_TABLE;
	
	
	public ComplisDaoSelectSingle(Connection conn, ComplisInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.COMPANY_LIST_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, ComplisInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new ComplisDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<ComplisInfo> getResultParserHook() {
		return new DaoResultParser<ComplisInfo>() {
			@Override public List<ComplisInfo> parseResult(ComplisInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {			
				List<ComplisInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					ComplisInfo dataInfo = new ComplisInfo();
					
					dataInfo.codOwner = stmtResult.getLong(ComplisDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codCompany = stmtResult.getLong(ComplisDaoDbTableColumn.COL_COD_COMPANY);
					dataInfo.name = stmtResult.getString(ComplisDaoDbTableColumn.COL_NAME);
					dataInfo.nameSearch = stmtResult.getString(ComplisDaoDbTableColumn.COL_NAME_SEARCH);
					dataInfo.email = stmtResult.getString(ComplisDaoDbTableColumn.COL_EMAIL);						
					dataInfo.recordMode = stmtResult.getString(ComplisDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.razaoSocial = stmtResult.getString(ComplisDaoDbTableColumn.COL_RAZAO_SOCIAL);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, ComplisDaoDbTableColumn.COL_COD_SNAPSHOT);				
					dataInfo.cnpj = stmtResult.getString(ComplisDaoDbTableColumn.COL_CNPJ);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
