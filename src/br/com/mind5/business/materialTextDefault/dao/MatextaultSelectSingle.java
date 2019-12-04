package br.com.mind5.business.materialTextDefault.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MatextaultSelectSingle extends DaoStmtTemplate<MatextaultInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_TEXT_TABLE;	
	
	public MatextaultSelectSingle(Connection conn, MatextaultInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.MAT_TEXT_DEFAULT_VIEW;	
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatextaultInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatextaultWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<MatextaultInfo> getResultParserHook() {
		return new DaoResultParserV2<MatextaultInfo>() {
			@Override public List<MatextaultInfo> parseResult(MatextaultInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatextaultInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					MatextaultInfo dataInfo = new MatextaultInfo();
					dataInfo.codOwner = stmtResult.getLong(MatextaultDbTableColumn.COL_COD_OWNER);
					dataInfo.codMat = stmtResult.getLong(MatextaultDbTableColumn.COL_COD_MATERIAL);
					dataInfo.codLanguage = stmtResult.getString(MatextaultDbTableColumn.COL_COD_LANGUAGE);
					dataInfo.recordMode = stmtResult.getString(MatextaultDbTableColumn.COL_RECORD_MODE);			
					dataInfo.isDefault = stmtResult.getBoolean(MatextaultDbTableColumn.COL_IS_DEFAULT);
					
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
