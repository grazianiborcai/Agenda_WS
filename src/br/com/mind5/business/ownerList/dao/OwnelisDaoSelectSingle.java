package br.com.mind5.business.ownerList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class OwnelisDaoSelectSingle extends DaoStmtTemplate<OwnelisInfo> {
	private final String MAIN_TABLE = DaoDbTable.OWNER_TABLE;	
	
	
	public OwnelisDaoSelectSingle(Connection conn, OwnelisInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.OWNER_LIST_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OwnelisInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OwnelisDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<OwnelisInfo> getResultParserHook() {
		return new DaoResultParser<OwnelisInfo>() {
			@Override public List<OwnelisInfo> parseResult(OwnelisInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OwnelisInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					OwnelisInfo dataInfo = new OwnelisInfo();
					
					dataInfo.codOwner = stmtResult.getLong(OwnelisDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.recordMode = stmtResult.getString(OwnelisDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codCompany = DaoFormatter.sqlToLong(stmtResult, OwnelisDaoDbTableColumn.COL_COD_COMPANY);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, OwnelisDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codBusiness = DaoFormatter.sqlToInt(stmtResult, OwnelisDaoDbTableColumn.COL_COD_BUSINESS);	
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
