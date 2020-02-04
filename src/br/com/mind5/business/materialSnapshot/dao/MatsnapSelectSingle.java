package br.com.mind5.business.materialSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MatsnapSelectSingle extends DaoStmtTemplate<MatsnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_SNAPSHOT_TABLE;
	
	
	public MatsnapSelectSingle(Connection conn, MatsnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatsnapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatsnapWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<MatsnapInfo> getResultParserHook() {
		return new DaoResultParser<MatsnapInfo>() {
			@Override public List<MatsnapInfo> parseResult(MatsnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatsnapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					MatsnapInfo dataInfo = new MatsnapInfo();
					dataInfo.codOwner = stmtResult.getLong(MatsnapDbTableColumn.COL_COD_OWNER);
					dataInfo.codSnapshot = stmtResult.getLong(MatsnapDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codMat = stmtResult.getLong(MatsnapDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codType = stmtResult.getInt(MatsnapDbTableColumn.COL_COD_TYPE);
					dataInfo.codMatCateg = stmtResult.getInt(MatsnapDbTableColumn.COL_COD_CATEGORY);
					dataInfo.priceUnit = stmtResult.getInt(MatsnapDbTableColumn.COL_PRICE_UNIT);	
					dataInfo.codUnit = stmtResult.getString(MatsnapDbTableColumn.COL_COD_UNIT);	
					dataInfo.codGroup = stmtResult.getInt(MatsnapDbTableColumn.COL_COD_GROUP);
					dataInfo.isLocked = stmtResult.getBoolean(MatsnapDbTableColumn.COL_IS_LOCKED);	
					dataInfo.recordMode = stmtResult.getString(MatsnapDbTableColumn.COL_RECORD_MODE);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, MatsnapDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, MatsnapDbTableColumn.COL_LAST_CHANGED_BY);		
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, MatsnapDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, MatsnapDbTableColumn.COL_CREATED_BY);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
