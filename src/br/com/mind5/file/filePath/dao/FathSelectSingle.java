package br.com.mind5.file.filePath.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.file.filePath.info.FathInfo;

public final class FathSelectSingle extends DaoStmtTemplate<FathInfo> {
	private final String MAIN_TABLE = DaoDbTable.FILE_PATH_TABLE;	
	
	
	public FathSelectSingle(Connection conn, FathInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, FathInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new FathWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<FathInfo> getResultParserHook() {
		return new DaoResultParser<FathInfo>() {
			@Override public List<FathInfo> parseResult(FathInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<FathInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					FathInfo dataInfo = new FathInfo();
					
					dataInfo.codFilePath = stmtResult.getString(FathDbTableColumn.COL_COD_FILE_PATH);
					dataInfo.filePath = stmtResult.getString(FathDbTableColumn.COL_FILE_PATH);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
