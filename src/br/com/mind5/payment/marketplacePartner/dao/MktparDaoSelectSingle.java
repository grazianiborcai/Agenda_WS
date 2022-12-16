package br.com.mind5.payment.marketplacePartner.dao;

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
import br.com.mind5.payment.marketplacePartner.info.MktparInfo;

public final class MktparDaoSelectSingle extends DaoStmtTemplate<MktparInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_MARKETPLACE_TABLE;
	
	
	public MktparDaoSelectSingle(Connection conn, MktparInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MktparInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MktparDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<MktparInfo> getResultParserHook() {
		return new DaoResultParser<MktparInfo>() {
			@Override public List<MktparInfo> parseResult(MktparInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MktparInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					MktparInfo dataInfo = new MktparInfo();
					
					dataInfo.idPayPartnerSystem = stmtResult.getString(MktparDaoDbTableColumn.COL_ID_PAY_PARTNER_SYSTEM);
					dataInfo.idPayPartnerApp = stmtResult.getString(MktparDaoDbTableColumn.COL_ID_PAY_PARTNER_APP);
					dataInfo.codPayPartner = stmtResult.getInt(MktparDaoDbTableColumn.COL_COD_PAY_PARTNER);
					dataInfo.payPartnerName = stmtResult.getString(MktparDaoDbTableColumn.COL_PAY_PARTNER_NAME);	
					dataInfo.urlReturn = stmtResult.getString(MktparDaoDbTableColumn.COL_URL_RETURN);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
