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

public final class OwnerDaoSelectSingle extends DaoStmtTemplate<OwnerInfo> {
	private final String MAIN_TABLE = DaoDbTable.OWNER_TABLE;	
	
	
	public OwnerDaoSelectSingle(Connection conn, OwnerInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new OwnerDaoWhere(whereOption, tableName, recordInfo);
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
					
					dataInfo.codOwner = stmtResult.getLong(OwnerDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.recordMode = stmtResult.getString(OwnerDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, OwnerDaoDbTableColumn.COL_COD_PERSON);
					dataInfo.codCompany = DaoFormatter.sqlToLong(stmtResult, OwnerDaoDbTableColumn.COL_COD_COMPANY);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, OwnerDaoDbTableColumn.COL_COD_USER);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, OwnerDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, OwnerDaoDbTableColumn.COL_LAST_CHANGED);				
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, OwnerDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, OwnerDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, OwnerDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codBusiness = DaoFormatter.sqlToInt(stmtResult, OwnerDaoDbTableColumn.COL_COD_BUSINESS);	
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
