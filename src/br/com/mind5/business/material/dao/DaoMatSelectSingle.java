package br.com.mind5.business.material.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoMatSelectSingle extends DaoStmtTemplate<MatInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_TABLE;	
	
	
	public DaoMatSelectSingle(Connection conn, MatInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoMatWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<MatInfo> getResultParserHook() {
		return new DaoResultParser<MatInfo>() {
			@Override public List<MatInfo> parseResult(MatInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					MatInfo dataInfo = new MatInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoMatDbTableColumn.COL_COD_OWNER);
					dataInfo.codMat = stmtResult.getLong(DaoMatDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codStore = stmtResult.getLong(DaoMatDbTableColumn.COL_COD_STORE);
					dataInfo.codType = stmtResult.getInt(DaoMatDbTableColumn.COL_COD_TYPE);
					dataInfo.codMatCateg = stmtResult.getInt(DaoMatDbTableColumn.COL_COD_CATEGORY);
					dataInfo.priceUnit = stmtResult.getInt(DaoMatDbTableColumn.COL_PRICE_UNIT);	
					dataInfo.codUnit = stmtResult.getString(DaoMatDbTableColumn.COL_COD_UNIT);	
					dataInfo.codGroup = stmtResult.getInt(DaoMatDbTableColumn.COL_COD_GROUP);
					dataInfo.codSubgroup = stmtResult.getInt(DaoMatDbTableColumn.COL_COD_MAT_SUBGROUP);					
					dataInfo.isLocked = stmtResult.getBoolean(DaoMatDbTableColumn.COL_IS_LOCKED);	
					dataInfo.recordMode = stmtResult.getString(DaoMatDbTableColumn.COL_RECORD_MODE);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoMatDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoMatDbTableColumn.COL_LAST_CHANGED);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoMatDbTableColumn.COL_COD_SNAPSHOT);		
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoMatDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoMatDbTableColumn.COL_CREATED_BY);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
