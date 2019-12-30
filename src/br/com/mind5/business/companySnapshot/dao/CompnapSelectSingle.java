package br.com.mind5.business.companySnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class CompnapSelectSingle extends DaoStmtTemplate<CompnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.COMP_SNAPHOT_TABLE;
	
	
	public CompnapSelectSingle(Connection conn, CompnapInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new CompnapWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<CompnapInfo> getResultParserHook() {
		return new DaoResultParserV2<CompnapInfo>() {
			@Override public List<CompnapInfo> parseResult(CompnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {	
				List<CompnapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CompnapInfo dataInfo = new CompnapInfo();
					
					dataInfo.codOwner = stmtResult.getLong(CompnapDbTableColumn.COL_COD_OWNER);
					dataInfo.codCompany = stmtResult.getLong(CompnapDbTableColumn.COL_COD_COMPANY);
					dataInfo.codSnapshot = stmtResult.getLong(CompnapDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.cnpj = stmtResult.getString(CompnapDbTableColumn.COL_CNPJ);
					dataInfo.name = stmtResult.getString(CompnapDbTableColumn.COL_NAME);			
					dataInfo.email = stmtResult.getString(CompnapDbTableColumn.COL_EMAIL);						
					dataInfo.recordMode = stmtResult.getString(CompnapDbTableColumn.COL_RECORD_MODE);
					dataInfo.codEntityCateg = stmtResult.getString(CompnapDbTableColumn.COL_COD_ENTITY_CATEG);
					dataInfo.codCountryLegal = stmtResult.getString(CompnapDbTableColumn.COL_COUNTRY_LEGAL);
					dataInfo.inscrEst = stmtResult.getString(CompnapDbTableColumn.COL_INSC_ESTATUAL);
					dataInfo.inscrMun = stmtResult.getString(CompnapDbTableColumn.COL_INSC_MUNICIPAL);
					dataInfo.razaoSocial = stmtResult.getString(CompnapDbTableColumn.COL_RAZAO_SOCIAL);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, CompnapDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, CompnapDbTableColumn.COL_LAST_CHANGED_BY);				
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, CompnapDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, CompnapDbTableColumn.COL_CREATED_BY);					
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
