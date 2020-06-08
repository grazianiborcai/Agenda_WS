package br.com.mind5.business.ownerSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerSearch.info.OwnarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoOwnarchSelectSingle extends DaoStmtTemplate<OwnarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.OWNER_TABLE;	
	
	
	public DaoOwnarchSelectSingle(Connection conn, OwnarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.OWNER_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OwnarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoOwnarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(OwnarchInfo recordInfo) {
		DaoJoinBuilder joinCompany = new DaoOwnarchJoinCompany(MAIN_TABLE);		
		return joinCompany.build();
	}
	
	
	
	@Override protected DaoResultParser<OwnarchInfo> getResultParserHook() {
		return new DaoResultParser<OwnarchInfo>() {
			@Override public List<OwnarchInfo> parseResult(OwnarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OwnarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					OwnarchInfo dataInfo = new OwnarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoOwnarchDbTableColumn.COL_COD_OWNER);
					dataInfo.recordMode = stmtResult.getString(DaoOwnarchDbTableColumn.COL_RECORD_MODE);
					dataInfo.codCompany = DaoFormatter.sqlToLong(stmtResult, DaoOwnarchDbTableColumn.COL_COD_COMPANY);		
					dataInfo.name = stmtResult.getString(DaoOwnarchDbTableColumn.COL_NAME);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
