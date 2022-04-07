package br.com.mind5.business.materialSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSearch.info.MatarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoJoinMatext;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MatarchDaoSelectSingle extends DaoStmtTemplate<MatarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_TABLE;	
	
	
	public MatarchDaoSelectSingle(Connection conn, MatarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.MAT_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(MatarchInfo recordInfo) {
		DaoJoinBuilder joinMatext = new DaoJoinMatext(MAIN_TABLE);		
		return joinMatext.build();
	}
	
	
	
	@Override protected DaoResultParser<MatarchInfo> getResultParserHook() {
		return new DaoResultParser<MatarchInfo>() {
			@Override public List<MatarchInfo> parseResult(MatarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					MatarchInfo dataInfo = new MatarchInfo();
					dataInfo.codOwner = stmtResult.getLong(MatarchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codMat = stmtResult.getLong(MatarchDaoDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codStore = stmtResult.getLong(MatarchDaoDbTableColumn.COL_COD_STORE);
					dataInfo.codType = stmtResult.getInt(MatarchDaoDbTableColumn.COL_COD_TYPE);
					dataInfo.codMatCateg = stmtResult.getInt(MatarchDaoDbTableColumn.COL_COD_CATEGORY);
					dataInfo.codGroup = stmtResult.getInt(MatarchDaoDbTableColumn.COL_COD_GROUP);
					dataInfo.isLocked = stmtResult.getBoolean(MatarchDaoDbTableColumn.COL_IS_LOCKED);	
					dataInfo.recordMode = stmtResult.getString(MatarchDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, MatarchDaoDbTableColumn.COL_COD_SNAPSHOT);	
					
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
