package br.com.mind5.payment.storePartner.dao;

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
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class DaoStoparSelectSingle extends DaoStmtTemplate<StoparInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_STORE_TABLE;
	
	
	public DaoStoparSelectSingle(Connection conn, StoparInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StoparInfo recordInfo) {	
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoStoparWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<StoparInfo> getResultParserHook() {
		return new DaoResultParser<StoparInfo>() {
			@Override public List<StoparInfo> parseResult(StoparInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StoparInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StoparInfo dataInfo = new StoparInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoStoparDbTableColumn.COL_COD_OWNER);
					dataInfo.codSnapshot = stmtResult.getLong(DaoStoparDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codStore = stmtResult.getLong(DaoStoparDbTableColumn.COL_COD_STORE);
					dataInfo.codPayPartner = stmtResult.getInt(DaoStoparDbTableColumn.COL_COD_PAY_PARTNER);
					dataInfo.recordMode = stmtResult.getString(DaoStoparDbTableColumn.COL_RECORD_MODE);
					dataInfo.codePayPartnerStore = stmtResult.getString(DaoStoparDbTableColumn.COL_CODE_PAY_PARTNER_STORE);
					dataInfo.idPayPartnerStore = stmtResult.getString(DaoStoparDbTableColumn.COL_ID_PAY_PARTNER_STORE);				
					dataInfo.accessToken = stmtResult.getString(DaoStoparDbTableColumn.COL_ACCESS_TOKEN);
					dataInfo.refreshToken = stmtResult.getString(DaoStoparDbTableColumn.COL_REFRESH_TOKEN);
					dataInfo.scope = stmtResult.getString(DaoStoparDbTableColumn.COL_SCOPE);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoStoparDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoStoparDbTableColumn.COL_LAST_CHANGED);
					dataInfo.tokenExpiresIn = DaoFormatter.sqlToLocalDate(stmtResult, DaoStoparDbTableColumn.COL_TOKEN_EXPIRES_IN);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
