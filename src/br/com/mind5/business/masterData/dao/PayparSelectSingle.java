package br.com.mind5.business.masterData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PayparSelectSingle extends DaoStmtTemplate<PayparInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_TABLE;
	
	
	public PayparSelectSingle(Connection conn, PayparInfo recordInfo, String schemaName) {
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
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.dummyClauseWhenEmpty = DaoOptionValue.DUMMY_CLAUSE_ALLOWED;
		
		DaoStmtWhere whereClause = new PayparWhere(whereOption, tableName, recordInfo);
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
					
					dataInfo.codPayPartner = stmtResult.getInt(MasterDataDbTableColumn.COL_COD_PAY_PARTNER);
					dataInfo.txtPayPartner = stmtResult.getString(MasterDataDbTableColumn.COL_NAME);
					dataInfo.description = stmtResult.getString(MasterDataDbTableColumn.COL_DESCRIPTION);	
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
