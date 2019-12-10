package br.com.mind5.business.materialMovement.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class MatmovSelectSingle extends DaoStmtTemplate<MatmovInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_MOVEMENT_TABLE;	
	
	
	public MatmovSelectSingle(Connection conn, MatmovInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatmovInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new MatmovWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParserV2<MatmovInfo> getResultParserHook() {
		return new DaoResultParserV2<MatmovInfo>() {
			@Override public List<MatmovInfo> parseResult(MatmovInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatmovInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					MatmovInfo dataInfo = new MatmovInfo();
					
					dataInfo.codOwner = stmtResult.getLong(MatmovDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(MatmovDbTableColumn.COL_COD_STORE);
					dataInfo.codMatmov = stmtResult.getLong(MatmovDbTableColumn.COL_COD_MAT_MOV);
					dataInfo.codMatmovType = DaoFormatter.sqlToChar(stmtResult, MatmovDbTableColumn.COL_COD_MAT_MOV_TYPE);
					dataInfo.codMat = stmtResult.getLong(MatmovDbTableColumn.COL_COD_MATERIAL);
					dataInfo.quantity = stmtResult.getInt(MatmovDbTableColumn.COL_QUANTITY);
					dataInfo.postingDate = DaoFormatter.sqlToLocalDate(stmtResult, MatmovDbTableColumn.COL_POSTING_DATE);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, MatmovDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, MatmovDbTableColumn.COL_LAST_CHANGED_BY);			
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
