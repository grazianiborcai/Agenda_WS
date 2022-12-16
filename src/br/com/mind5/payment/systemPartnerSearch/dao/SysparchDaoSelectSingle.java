package br.com.mind5.payment.systemPartnerSearch.dao;

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
import br.com.mind5.payment.systemPartnerSearch.info.SysparchInfo;

public final class SysparchDaoSelectSingle extends DaoStmtTemplate<SysparchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_MARKETPLACE_TABLE;
	
	
	public SysparchDaoSelectSingle(Connection conn, SysparchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.SYS_PAY_PARTNER_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SysparchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SysparchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SysparchInfo> getResultParserHook() {
		return new DaoResultParser<SysparchInfo>() {
			@Override public List<SysparchInfo> parseResult(SysparchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SysparchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SysparchInfo dataInfo = new SysparchInfo();
					
					dataInfo.idPayPartnerSystem = stmtResult.getString(SysparchDaoDbTableColumn.COL_ID_PAY_PARTNER_SYSTEM);
					dataInfo.idPayPartnerApp = stmtResult.getString(SysparchDaoDbTableColumn.COL_ID_PAY_PARTNER_APP);
					dataInfo.codPayPartner = stmtResult.getInt(SysparchDaoDbTableColumn.COL_COD_PAY_PARTNER);		
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
