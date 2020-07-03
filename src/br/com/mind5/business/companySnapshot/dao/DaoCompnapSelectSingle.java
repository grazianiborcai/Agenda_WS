package br.com.mind5.business.companySnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoCompnapSelectSingle extends DaoStmtTemplate<CompnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.COMP_SNAPHOT_TABLE;
	
	
	public DaoCompnapSelectSingle(Connection conn, CompnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CompnapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoCompnapWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<CompnapInfo> getResultParserHook() {
		return new DaoResultParser<CompnapInfo>() {
			@Override public List<CompnapInfo> parseResult(CompnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {	
				List<CompnapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CompnapInfo dataInfo = new CompnapInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoCompnapDbTableColumn.COL_COD_OWNER);
					dataInfo.codCompany = stmtResult.getLong(DaoCompnapDbTableColumn.COL_COD_COMPANY);
					dataInfo.codSnapshot = stmtResult.getLong(DaoCompnapDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.cnpj = stmtResult.getString(DaoCompnapDbTableColumn.COL_CNPJ);
					dataInfo.name = stmtResult.getString(DaoCompnapDbTableColumn.COL_NAME);
					dataInfo.nameSearch = stmtResult.getString(DaoCompnapDbTableColumn.COL_NAME_SEARCH);	
					dataInfo.email = stmtResult.getString(DaoCompnapDbTableColumn.COL_EMAIL);						
					dataInfo.recordMode = stmtResult.getString(DaoCompnapDbTableColumn.COL_RECORD_MODE);
					dataInfo.codEntityCateg = stmtResult.getString(DaoCompnapDbTableColumn.COL_COD_ENTITY_CATEG);
					dataInfo.codCountryLegal = stmtResult.getString(DaoCompnapDbTableColumn.COL_COUNTRY_LEGAL);
					dataInfo.inscrEst = stmtResult.getString(DaoCompnapDbTableColumn.COL_INSC_ESTATUAL);
					dataInfo.inscrMun = stmtResult.getString(DaoCompnapDbTableColumn.COL_INSC_MUNICIPAL);
					dataInfo.razaoSocial = stmtResult.getString(DaoCompnapDbTableColumn.COL_RAZAO_SOCIAL);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoCompnapDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoCompnapDbTableColumn.COL_LAST_CHANGED_BY);				
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoCompnapDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoCompnapDbTableColumn.COL_CREATED_BY);					
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
