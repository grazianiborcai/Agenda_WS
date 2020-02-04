package br.com.mind5.business.feeDefault.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class FeedefSelectSingle extends DaoStmtTemplate<FeedefInfo> {
	private final String MAIN_TABLE = DaoDbTable.FEE_DEFAULT_TABLE;
		
	
	public FeedefSelectSingle(Connection conn, FeedefInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FeedefInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new FeedefWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<FeedefInfo> getResultParserHook() {
		return new DaoResultParser<FeedefInfo>() {
			@Override public List<FeedefInfo> parseResult(FeedefInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FeedefInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					FeedefInfo dataInfo = new FeedefInfo();
					
					dataInfo.codFeeCateg = DaoFormatter.sqlToChar(stmtResult, FeedefDbTableColumn.COL_COD_FEE_CATEG);
					dataInfo.codCurr = stmtResult.getString(FeedefDbTableColumn.COL_COD_CURRENCY);
					dataInfo.price = DaoFormatter.sqlToDouble(stmtResult, FeedefDbTableColumn.COL_VALUE);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
