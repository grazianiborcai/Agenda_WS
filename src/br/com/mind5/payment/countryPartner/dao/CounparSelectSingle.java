package br.com.mind5.payment.countryPartner.dao;

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
import br.com.mind5.payment.countryPartner.info.CounparInfo;

public final class CounparSelectSingle extends DaoStmtTemplate<CounparInfo> {
	private final String MAIN_TABLE = DaoDbTable.PAY_PARTNER_COUNTRY_TABLE;
	
	
	public CounparSelectSingle(Connection conn, CounparInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, CounparInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new CounparWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<CounparInfo> getResultParserHook() {
		return new DaoResultParser<CounparInfo>() {
			@Override public List<CounparInfo> parseResult(CounparInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<CounparInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					CounparInfo dataInfo = new CounparInfo();
					
					dataInfo.codCountry = stmtResult.getString(CounparDbTableColumn.COL_COD_COUNTRY);
					dataInfo.codPayPartner = stmtResult.getInt(CounparDbTableColumn.COL_COD_PAY_PARTNER);
					dataInfo.isDefault = DaoFormatter.sqlToBoole(stmtResult, CounparDbTableColumn.COL_IS_DEFAULT);					
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
