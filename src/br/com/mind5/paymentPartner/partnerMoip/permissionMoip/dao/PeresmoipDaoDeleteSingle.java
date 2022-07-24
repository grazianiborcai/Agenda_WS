package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.dao;

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
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class PeresmoipDaoDeleteSingle extends DaoStmtTemplate<PeresmoipInfo> {
	private final String MAIN_TABLE = DaoDbTable.MOIP_PERMISSION_RESPONSE_TABLE;	
	
	
	public PeresmoipDaoDeleteSingle(Connection conn, PeresmoipInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new PeresmoipDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<PeresmoipInfo> getResultParserHook() {
		return new DaoResultParser<PeresmoipInfo>() {
			@Override public List<PeresmoipInfo> parseResult(PeresmoipInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PeresmoipInfo> finalResult = new ArrayList<>();
				PeresmoipInfo emptyInfo = new PeresmoipInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
