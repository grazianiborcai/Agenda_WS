package br.com.mind5.business.ownerSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class OwnerapDaoSelectSingle extends DaoStmtTemplate<OwnerapInfo> {
	private final String MAIN_TABLE = DaoDbTable.OWNER_SNAPSHOT_TABLE;	
	
	
	public OwnerapDaoSelectSingle(Connection conn, OwnerapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, OwnerapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new OwnerapDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<OwnerapInfo> getResultParserHook() {
		return new DaoResultParser<OwnerapInfo>() {
			@Override public List<OwnerapInfo> parseResult(OwnerapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<OwnerapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					OwnerapInfo dataInfo = new OwnerapInfo();
					
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, OwnerapDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codOwner = stmtResult.getLong(OwnerapDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.recordMode = stmtResult.getString(OwnerapDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, OwnerapDaoDbTableColumn.COL_COD_PERSON);
					dataInfo.codPersonSnapshot = DaoFormatter.sqlToLong(stmtResult, OwnerapDaoDbTableColumn.COL_COD_PERSON_SNAPSHOT);				
					dataInfo.codCompany = DaoFormatter.sqlToLong(stmtResult, OwnerapDaoDbTableColumn.COL_COD_COMPANY);
					dataInfo.codCompanySnapshot = DaoFormatter.sqlToLong(stmtResult, OwnerapDaoDbTableColumn.COL_COD_COMPANY_SNAPSHOT);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, OwnerapDaoDbTableColumn.COL_COD_USER);
					dataInfo.codUserSnapshot = DaoFormatter.sqlToLong(stmtResult, OwnerapDaoDbTableColumn.COL_COD_USER_SNAPSHOT);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, OwnerapDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, OwnerapDaoDbTableColumn.COL_LAST_CHANGED);				
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, OwnerapDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, OwnerapDaoDbTableColumn.COL_CREATED_ON);	
					dataInfo.codBusiness = DaoFormatter.sqlToInt(stmtResult, OwnerapDaoDbTableColumn.COL_COD_BUSINESS);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
