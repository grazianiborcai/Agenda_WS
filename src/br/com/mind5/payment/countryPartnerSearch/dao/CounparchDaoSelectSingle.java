package br.com.mind5.payment.countryPartnerSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;

public final class CounparchDaoSelectSingle extends DaoStmtTemplate<CounparchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_COUNTRY_TABLE;
	
	
	public CounparchDaoSelectSingle(Connection conn, CounparchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PAY_PARTNER_COUNTRY_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CounparchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new CounparchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<CounparchInfo> getResultParserHook() {
		return new DaoResultParser<CounparchInfo>() {
			@Override public List<CounparchInfo> parseResult(CounparchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CounparchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CounparchInfo dataInfo = new CounparchInfo();
					
					dataInfo.codCountry = stmtResult.getString(CounparchDaoDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codPayPartner = stmtResult.getInt(CounparchDaoDbTableColumn.COL_COD_PAY_PARTNER);
					dataInfo.isDefault = DaoFormatter.sqlToBoole(stmtResult, CounparchDaoDbTableColumn.COL_IS_DEFAULT);					
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
