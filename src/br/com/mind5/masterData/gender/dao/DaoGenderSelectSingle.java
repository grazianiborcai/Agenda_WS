package br.com.mind5.masterData.gender.dao;

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
import br.com.mind5.masterData.gender.info.GenderInfo;

public final class DaoGenderSelectSingle extends DaoStmtTemplate<GenderInfo> {
	private final String MAIN_TABLE = DaoDbTable.GENDER_TABLE;
	
	
	public DaoGenderSelectSingle(Connection conn, GenderInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, GenderInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoGenderWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(GenderInfo recordInfo) {
		DaoJoinBuilder joinText = new DaoGenderJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}
	
	
	
	@Override protected DaoResultParser<GenderInfo> getResultParserHook() {
		return new DaoResultParser<GenderInfo>() {
			@Override public List<GenderInfo> parseResult(GenderInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<GenderInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					GenderInfo dataInfo = new GenderInfo();
					
					dataInfo.codGender = stmtResult.getInt(DaoGenderDbTableColumn.COL_COD_GENDER);
					dataInfo.txtGender = stmtResult.getString(DaoGenderDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(DaoGenderDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
