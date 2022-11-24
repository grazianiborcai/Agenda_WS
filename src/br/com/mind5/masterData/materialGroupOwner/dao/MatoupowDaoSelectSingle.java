package br.com.mind5.masterData.materialGroupOwner.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.materialGroupOwner.info.MatoupowInfo;

public final class MatoupowDaoSelectSingle extends DaoStmtTemplate<MatoupowInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_GROUP_OWNER_TABLE;
	
	
	public MatoupowDaoSelectSingle(Connection conn, MatoupowInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatoupowInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new MatoupowDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<MatoupowInfo> getResultParserHook() {
		return new DaoResultParser<MatoupowInfo>() {			
			@Override public List<MatoupowInfo> parseResult(MatoupowInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatoupowInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MatoupowInfo dataInfo = new MatoupowInfo();
					
					dataInfo.codGroup 		= stmtResult.getInt(MatoupowDaoDbTableColumn.COL_COD_MAT_GROUP);		
					dataInfo.codOwner 		= stmtResult.getLong(MatoupowDaoDbTableColumn.COL_COD_OWNER);					
					dataInfo.isLocked 		= DaoFormatter.sqlToBoole(stmtResult, MatoupowDaoDbTableColumn.COL_IS_LOCKED);
					dataInfo.recordMode 	= stmtResult.getString(MatoupowDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.lastChangedBy 	= DaoFormatter.sqlToLong(stmtResult, MatoupowDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.lastChanged 	= DaoFormatter.sqlToLocalDateTime(stmtResult, MatoupowDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.createdOn 		= DaoFormatter.sqlToLocalDateTime(stmtResult, MatoupowDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy 		= DaoFormatter.sqlToLong(stmtResult, MatoupowDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.rgbDecBlue 	= DaoFormatter.sqlToInt(stmtResult, MatoupowDaoDbTableColumn.COL_RGB_DEC_BLUE);
					dataInfo.rgbDecGreen 	= DaoFormatter.sqlToInt(stmtResult, MatoupowDaoDbTableColumn.COL_RGB_DEC_GREEN);
					dataInfo.rgbDecRed 		= DaoFormatter.sqlToInt(stmtResult, MatoupowDaoDbTableColumn.COL_RGB_DEC_RED);
					dataInfo.rgbHex 		= stmtResult.getString(MatoupowDaoDbTableColumn.COL_RGB_HEX);
					
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
