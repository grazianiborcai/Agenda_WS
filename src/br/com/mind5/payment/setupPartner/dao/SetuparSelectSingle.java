package br.com.mind5.payment.setupPartner.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class SetuparSelectSingle extends DaoStmtTemplate<SetuparInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_SETUP_TABLE;
	
	
	public SetuparSelectSingle(Connection conn, SetuparInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SetuparInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SetuparWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParserV2<SetuparInfo> getResultParserHook() {
		return new DaoResultParserV2<SetuparInfo>() {
			@Override public List<SetuparInfo> parseResult(SetuparInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SetuparInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SetuparInfo dataInfo = new SetuparInfo();
					
					dataInfo.codPayPartner = stmtResult.getInt(SetuparDbTableColumn.COL_COD_PAY_PARTNER);
					dataInfo.basicKey = stmtResult.getString(SetuparDbTableColumn.COL_BASIC_KEY);
					dataInfo.basicToken = stmtResult.getString(SetuparDbTableColumn.COL_BASIC_TOKEN);		
					dataInfo.secret = stmtResult.getString(SetuparDbTableColumn.COL_SECRET);
					dataInfo.oauthToken = stmtResult.getString(SetuparDbTableColumn.COL_OAUTH_TOKEN);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
