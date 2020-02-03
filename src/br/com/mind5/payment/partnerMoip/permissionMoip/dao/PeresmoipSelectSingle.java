package br.com.mind5.payment.partnerMoip.permissionMoip.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class PeresmoipSelectSingle extends DaoStmtTemplate<PeresmoipInfo> {
	private final String MAIN_TABLE = DaoDbTable.MOIP_PERMISSION_RESPONSE_TABLE;
	
	
	public PeresmoipSelectSingle(Connection conn, PeresmoipInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PeresmoipInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PeresmoipWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParserV2<PeresmoipInfo> getResultParserHook() {
		return new DaoResultParserV2<PeresmoipInfo>() {
			@Override public List<PeresmoipInfo> parseResult(PeresmoipInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PeresmoipInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PeresmoipInfo dataInfo = new PeresmoipInfo();
					
					dataInfo.codOwner = stmtResult.getLong(PeresmoipDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(PeresmoipDbTableColumn.COL_COD_STORE);
					dataInfo.isExpected = stmtResult.getBoolean(PeresmoipDbTableColumn.COL_IS_EXPECTED);
					dataInfo.username = stmtResult.getString(PeresmoipDbTableColumn.COL_USERNAME);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, PeresmoipDbTableColumn.COL_LAST_CHANGED);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
