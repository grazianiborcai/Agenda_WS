package br.com.mind5.payment.ownerPartner.dao;

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
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

public final class OwnparSelectSingle extends DaoStmtTemplate<OwnparInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_OWNER_TABLE;
	
	
	
	public OwnparSelectSingle(Connection conn, OwnparInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OwnparInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OwnparWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<OwnparInfo> getResultParserHook() {
		return new DaoResultParser<OwnparInfo>() {
			@Override public List<OwnparInfo> parseResult(OwnparInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OwnparInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					OwnparInfo dataInfo = new OwnparInfo();
					
					dataInfo.codOwner = stmtResult.getLong(OwnparDbTableColumn.COL_COD_OWNER);
					dataInfo.codPayPartner = stmtResult.getInt(OwnparDbTableColumn.COL_COD_PAY_PARTNER);
					dataInfo.isDefault = DaoFormatter.sqlToBoole(stmtResult, OwnparDbTableColumn.COL_IS_DEFAULT);
					
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
