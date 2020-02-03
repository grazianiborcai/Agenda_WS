package br.com.mind5.payment.partnerMoip.permissionMoip.dao;

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
import br.com.mind5.payment.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class PeresmoipDeleteSingle extends DaoStmtTemplate<PeresmoipInfo> {
	private final String MAIN_TABLE = DaoDbTable.MOIP_PERMISSION_RESPONSE_TABLE;	
	
	
	public PeresmoipDeleteSingle(Connection conn, PeresmoipInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.HARD_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PeresmoipInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new PeresmoipWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<PeresmoipInfo> getResultParserHook() {
		return new DaoResultParserV2<PeresmoipInfo>() {
			@Override public List<PeresmoipInfo> parseResult(PeresmoipInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PeresmoipInfo> finalResult = new ArrayList<>();
				PeresmoipInfo emptyInfo = new PeresmoipInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
