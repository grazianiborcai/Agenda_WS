package br.com.mind5.business.company.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CompDaoSelectSingle extends DaoStmtTemplate<CompInfo> {
	private final String MAIN_TABLE = DaoDbTable.COMP_TABLE;
	
	
	public CompDaoSelectSingle(Connection conn, CompInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CompInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new CompDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<CompInfo> getResultParserHook() {
		return new DaoResultParser<CompInfo>() {
			@Override public List<CompInfo> parseResult(CompInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {		
				List<CompInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CompInfo dataInfo = new CompInfo();
					
					dataInfo.codOwner = stmtResult.getLong(CompDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codCompany = stmtResult.getLong(CompDaoDbTableColumn.COL_COD_COMPANY);
					dataInfo.cnpj = stmtResult.getString(CompDaoDbTableColumn.COL_CNPJ);
					dataInfo.name = stmtResult.getString(CompDaoDbTableColumn.COL_NAME);
					dataInfo.nameSearch = stmtResult.getString(CompDaoDbTableColumn.COL_NAME_SEARCH);
					dataInfo.email = stmtResult.getString(CompDaoDbTableColumn.COL_EMAIL);						
					dataInfo.recordMode = stmtResult.getString(CompDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codEntityCateg = stmtResult.getString(CompDaoDbTableColumn.COL_COD_ENTITY_CATEG);
					dataInfo.codCountryLegal = stmtResult.getString(CompDaoDbTableColumn.COL_COUNTRY_LEGAL);
					dataInfo.inscrEst = stmtResult.getString(CompDaoDbTableColumn.COL_INSC_ESTATUAL);
					dataInfo.inscrMun = stmtResult.getString(CompDaoDbTableColumn.COL_INSC_MUNICIPAL);
					dataInfo.razaoSocial = stmtResult.getString(CompDaoDbTableColumn.COL_RAZAO_SOCIAL);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, CompDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, CompDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, CompDaoDbTableColumn.COL_COD_SNAPSHOT);	
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, CompDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, CompDaoDbTableColumn.COL_CREATED_BY);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
