package br.com.mind5.payment.systemPartner.dao;

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
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class SysparDaoSelectSingle extends DaoStmtTemplate<SysparInfo> {
	private final String MAIN_TABLE = DaoDbTable.SYS_PAY_PARTNER_TABLE;
	
	
	public SysparDaoSelectSingle(Connection conn, SysparInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SysparInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new SysparDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<SysparInfo> getResultParserHook() {
		return new DaoResultParser<SysparInfo>() {
			@Override public List<SysparInfo> parseResult(SysparInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SysparInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					SysparInfo dataInfo = new SysparInfo();
					
					dataInfo.idPayPartnerSystem = stmtResult.getString(SysparDaoDbTableColumn.COL_ID_PAY_PARTNER_SYSTEM);
					dataInfo.idPayPartnerApp = stmtResult.getString(SysparDaoDbTableColumn.COL_ID_PAY_PARTNER_APP);
					dataInfo.codPayPartner = stmtResult.getInt(SysparDaoDbTableColumn.COL_COD_PAY_PARTNER);
					dataInfo.payPartnerName = stmtResult.getString(SysparDaoDbTableColumn.COL_PAY_PARTNER_NAME);	
					dataInfo.urlReturn = stmtResult.getString(SysparDaoDbTableColumn.COL_URL_RETURN);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
