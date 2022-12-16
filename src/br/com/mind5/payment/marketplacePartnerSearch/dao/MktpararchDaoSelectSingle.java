package br.com.mind5.payment.marketplacePartnerSearch.dao;

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
import br.com.mind5.payment.marketplacePartnerSearch.info.MktpararchInfo;

public final class MktpararchDaoSelectSingle extends DaoStmtTemplate<MktpararchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_MARKETPLACE_TABLE;
	
	
	public MktpararchDaoSelectSingle(Connection conn, MktpararchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PAY_PARTNER_MARKETPLACE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MktpararchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MktpararchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<MktpararchInfo> getResultParserHook() {
		return new DaoResultParser<MktpararchInfo>() {
			@Override public List<MktpararchInfo> parseResult(MktpararchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MktpararchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					MktpararchInfo dataInfo = new MktpararchInfo();
					
					dataInfo.idPayPartnerSystem = stmtResult.getString(MktpararchDaoDbTableColumn.COL_ID_PAY_PARTNER_SYSTEM);
					dataInfo.idPayPartnerApp = stmtResult.getString(MktpararchDaoDbTableColumn.COL_ID_PAY_PARTNER_APP);
					dataInfo.codPayPartner = stmtResult.getInt(MktpararchDaoDbTableColumn.COL_COD_PAY_PARTNER);		
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
