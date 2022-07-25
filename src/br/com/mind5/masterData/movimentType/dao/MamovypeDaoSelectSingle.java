package br.com.mind5.masterData.movimentType.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.masterData.movimentType.info.MamovypeInfo;

public final class MamovypeDaoSelectSingle extends DaoStmtTemplate<MamovypeInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_MOV_TYPE_TABLE;
	
	
	public MamovypeDaoSelectSingle(Connection conn, MamovypeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MamovypeInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new MamovypeDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(MamovypeInfo recordInfo) {
		DaoJoinBuilder joinText = new MamovypeDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<MamovypeInfo> getResultParserHook() {
		return new DaoResultParser<MamovypeInfo>() {
			@Override public List<MamovypeInfo> parseResult(MamovypeInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MamovypeInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					MamovypeInfo dataInfo = new MamovypeInfo();
					
					dataInfo.codMatmovType = DaoFormatter.sqlToChar(stmtResult, MamovypeDaoDbTableColumn.COL_COD_MAT_MOV_TYPE);
					dataInfo.txtMatmovType = stmtResult.getString(MamovypeDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(MamovypeDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	} 
}
