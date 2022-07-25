package br.com.mind5.masterData.paymentPartner.dao;

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
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;

public final class PayparDaoSelectSingle extends DaoStmtTemplate<PayparInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_TABLE;
	
	
	public PayparDaoSelectSingle(Connection conn, PayparInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PayparInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new PayparDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<PayparInfo> getResultParserHook() {
		return new DaoResultParser<PayparInfo>() {
			@Override public List<PayparInfo> parseResult(PayparInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PayparInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					PayparInfo dataInfo = new PayparInfo();
					
					dataInfo.codPayPartner = stmtResult.getInt(PayparDaoDbTableColumn.COL_COD_PAY_PARTNER);
					dataInfo.txtPayPartner = stmtResult.getString(PayparDaoDbTableColumn.COL_NAME);
					dataInfo.description = stmtResult.getString(PayparDaoDbTableColumn.COL_DESCRIPTION);	
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
