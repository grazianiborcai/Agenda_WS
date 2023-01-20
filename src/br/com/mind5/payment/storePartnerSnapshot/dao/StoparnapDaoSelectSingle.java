package br.com.mind5.payment.storePartnerSnapshot.dao;

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
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class StoparnapDaoSelectSingle extends DaoStmtTemplate<StoparnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_STORE_SNAPSHOT_TABLE;
	
	
	public StoparnapDaoSelectSingle(Connection conn, StoparnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoparnapInfo recordInfo) {	
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new StoparnapDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<StoparnapInfo> getResultParserHook() {
		return new DaoResultParser<StoparnapInfo>() {
			@Override public List<StoparnapInfo> parseResult(StoparnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoparnapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StoparnapInfo dataInfo = new StoparnapInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, StoparnapDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, StoparnapDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, StoparnapDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codPayPartner = DaoFormatter.sqlToInt(stmtResult, StoparnapDaoDbTableColumn.COL_COD_PAY_PARTNER);
					dataInfo.recordMode = stmtResult.getString(StoparnapDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, StoparnapDaoDbTableColumn.COL_LAST_CHANGED);					
					dataInfo.idPayPartnerStore = stmtResult.getString(StoparnapDaoDbTableColumn.COL_ID_PAY_PARTNER_STORE);
					dataInfo.codePayPartnerStore = stmtResult.getString(StoparnapDaoDbTableColumn.COL_CODE_PAY_PARTNER_STORE);
					dataInfo.accessToken = stmtResult.getString(StoparnapDaoDbTableColumn.COL_ACCESS_TOKEN);
					dataInfo.refreshToken = stmtResult.getString(StoparnapDaoDbTableColumn.COL_REFRESH_TOKEN);
					dataInfo.scope = stmtResult.getString(StoparnapDaoDbTableColumn.COL_SCOPE);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, StoparnapDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, StoparnapDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.tokenExpiresIn = DaoFormatter.sqlToLocalDate(stmtResult, StoparnapDaoDbTableColumn.COL_TOKEN_EXPIRES_IN);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
