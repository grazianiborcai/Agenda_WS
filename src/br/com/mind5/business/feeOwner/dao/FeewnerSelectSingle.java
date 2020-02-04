package br.com.mind5.business.feeOwner.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.feeOwner.info.FeewnerInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class FeewnerSelectSingle extends DaoStmtTemplate<FeewnerInfo> {
	private final String MAIN_TABLE = DaoDbTable.FEE_OWNER_TABLE;
	
	
	public FeewnerSelectSingle(Connection conn, FeewnerInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FeewnerInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new FeewnerWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<FeewnerInfo> getResultParserHook() {
		return new DaoResultParser<FeewnerInfo>() {
			@Override public List<FeewnerInfo> parseResult(FeewnerInfo redcordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FeewnerInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					FeewnerInfo dataInfo = new FeewnerInfo();
					
					dataInfo.codOwner = stmtResult.getLong(FeewnerDbTableColumn.COL_COD_OWNER);
					dataInfo.codCurr = stmtResult.getString(FeewnerDbTableColumn.COL_COD_CURRENCY);
					dataInfo.codFeeCateg = DaoFormatter.sqlToChar(stmtResult, FeewnerDbTableColumn.COL_COD_FEE_CATEG);
					dataInfo.price = DaoFormatter.sqlToDouble(stmtResult, FeewnerDbTableColumn.COL_VALUE);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
