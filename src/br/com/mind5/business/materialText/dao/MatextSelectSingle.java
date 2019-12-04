package br.com.mind5.business.materialText.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialText.info.MatextInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MatextSelectSingle extends DaoStmtTemplate<MatextInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_TEXT_TABLE;
	
	
	public MatextSelectSingle(Connection conn, MatextInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatextInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatextWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<MatextInfo> getResultParserHook() {
		return new DaoResultParserV2<MatextInfo>() {
			@Override public List<MatextInfo> parseResult(MatextInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatextInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					MatextInfo dataInfo = new MatextInfo();
					dataInfo.codOwner = stmtResult.getLong(MatextDbTableColumn.COL_COD_OWNER);
					dataInfo.codMat = stmtResult.getLong(MatextDbTableColumn.COL_COD_MATERIAL);
					dataInfo.txtMat = stmtResult.getString(MatextDbTableColumn.COL_NAME);
					dataInfo.description = stmtResult.getString(MatextDbTableColumn.COL_DESCRIPTION);
					dataInfo.codLanguage = stmtResult.getString(MatextDbTableColumn.COL_COD_LANGUAGE);	
					dataInfo.isDefault = stmtResult.getBoolean(MatextDbTableColumn.COL_IS_DEFAULT);	
					dataInfo.recordMode = stmtResult.getString(MatextDbTableColumn.COL_RECORD_MODE);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, MatextDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, MatextDbTableColumn.COL_LAST_CHANGED_BY);					
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, MatextDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, MatextDbTableColumn.COL_CREATED_BY);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
