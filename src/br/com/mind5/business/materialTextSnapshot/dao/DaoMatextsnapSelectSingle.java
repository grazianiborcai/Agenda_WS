package br.com.mind5.business.materialTextSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public class DaoMatextsnapSelectSingle extends DaoStmtTemplate<MatextsnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_TEXT_SNAPSHOT_TABLE;
	
	
	public DaoMatextsnapSelectSingle(Connection conn, MatextsnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatextsnapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoMatextsnapWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	
	@Override protected DaoResultParser<MatextsnapInfo> getResultParserHook() {
		return new DaoResultParser<MatextsnapInfo>() {
			@Override public List<MatextsnapInfo> parseResult(MatextsnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatextsnapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					MatextsnapInfo dataInfo = new MatextsnapInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoMatextsnapDbTableColumn.COL_COD_OWNER);
					dataInfo.codSnapshot = stmtResult.getLong(DaoMatextsnapDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codMat = stmtResult.getLong(DaoMatextsnapDbTableColumn.COL_COD_MATERIAL);
					dataInfo.txtMat = stmtResult.getString(DaoMatextsnapDbTableColumn.COL_NAME);
					dataInfo.txtMatSearch = stmtResult.getString(DaoMatextsnapDbTableColumn.COL_NAME_SEARCH);
					dataInfo.description = stmtResult.getString(DaoMatextsnapDbTableColumn.COL_DESCRIPTION);
					dataInfo.codLanguage = stmtResult.getString(DaoMatextsnapDbTableColumn.COL_COD_LANGUAGE);	
					dataInfo.isDefault = stmtResult.getBoolean(DaoMatextsnapDbTableColumn.COL_IS_DEFAULT);	
					dataInfo.recordMode = stmtResult.getString(DaoMatextsnapDbTableColumn.COL_RECORD_MODE);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoMatextsnapDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoMatextsnapDbTableColumn.COL_LAST_CHANGED_BY);					
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoMatextsnapDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoMatextsnapDbTableColumn.COL_CREATED_BY);					
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
