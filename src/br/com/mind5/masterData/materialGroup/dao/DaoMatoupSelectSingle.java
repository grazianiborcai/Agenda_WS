package br.com.mind5.masterData.materialGroup.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.materialGroup.info.MatoupInfo;

public final class DaoMatoupSelectSingle extends DaoStmtTemplate<MatoupInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_GROUP_TABLE;
	
	
	public DaoMatoupSelectSingle(Connection conn, MatoupInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatoupInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoMatoupWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook(MatoupInfo recordInfo) {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinText = new DaoMatoupJoinTxt(MAIN_TABLE);		
		joins.add(joinText.build());
		
		return joins;
	}
	
	
	
	@Override protected DaoResultParser<MatoupInfo> getResultParserHook() {
		return new DaoResultParser<MatoupInfo>() {			
			@Override public List<MatoupInfo> parseResult(MatoupInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatoupInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MatoupInfo dataInfo = new MatoupInfo();
					
					dataInfo.codGroup = stmtResult.getInt(DaoMatoupDbTableColumn.COL_COD_MAT_GROUP);				
					dataInfo.txtGroup = stmtResult.getString(DaoMatoupDbTableColumn.COL_NAME);
					dataInfo.codBusiness = stmtResult.getInt(DaoMatoupDbTableColumn.COL_COD_BUSINESS);
					dataInfo.codLanguage = stmtResult.getString(DaoMatoupDbTableColumn.COL_COD_LANGUAGE);		
					
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
