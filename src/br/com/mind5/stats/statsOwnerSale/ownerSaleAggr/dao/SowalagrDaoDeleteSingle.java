package br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.dao;

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
import br.com.mind5.stats.statsOwnerSale.ownerSaleAggr.info.SowalagrInfo;

public final class SowalagrDaoDeleteSingle extends DaoStmtTemplate<SowalagrInfo> {
	private final String MAIN_TABLE = DaoDbTable.STAT_OWNER_SALE_TABLE;	
	
	
	public SowalagrDaoDeleteSingle(Connection conn, SowalagrInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.HARD_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, SowalagrInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new SowalagrDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<SowalagrInfo> getResultParserHook() {
		return new DaoResultParser<SowalagrInfo>() {
			@Override public List<SowalagrInfo> parseResult(SowalagrInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<SowalagrInfo> finalResult = new ArrayList<>();
				SowalagrInfo emptyInfo = new SowalagrInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
