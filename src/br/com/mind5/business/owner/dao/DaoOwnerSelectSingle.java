package br.com.mind5.business.owner.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoOwnerSelectSingle extends DaoStmtTemplate<OwnerInfo> {
	private final String MAIN_TABLE = DaoDbTable.OWNER_TABLE;	
	
	
	public DaoOwnerSelectSingle(Connection conn, OwnerInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OwnerInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoOwnerWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<OwnerInfo> getResultParserHook() {
		return new DaoResultParser<OwnerInfo>() {
			@Override public List<OwnerInfo> parseResult(OwnerInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OwnerInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					OwnerInfo dataInfo = new OwnerInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoOwnerDbTableColumn.COL_COD_OWNER);
					dataInfo.recordMode = stmtResult.getString(DaoOwnerDbTableColumn.COL_RECORD_MODE);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, DaoOwnerDbTableColumn.COL_COD_PERSON);
					dataInfo.codCompany = DaoFormatter.sqlToLong(stmtResult, DaoOwnerDbTableColumn.COL_COD_COMPANY);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoOwnerDbTableColumn.COL_COD_USER);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoOwnerDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoOwnerDbTableColumn.COL_LAST_CHANGED);				
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoOwnerDbTableColumn.COL_CREATED_BY);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoOwnerDbTableColumn.COL_CREATED_ON);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoOwnerDbTableColumn.COL_COD_SNAPSHOT);				
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
