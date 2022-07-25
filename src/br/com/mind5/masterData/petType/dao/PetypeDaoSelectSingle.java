package br.com.mind5.masterData.petType.dao;

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
import br.com.mind5.masterData.petType.info.PetypeInfo;

public final class PetypeDaoSelectSingle extends DaoStmtTemplate<PetypeInfo> {
	private final String MAIN_TABLE = DaoDbTable.PET_TYPE_TABLE;
	
	
	public PetypeDaoSelectSingle(Connection conn, PetypeInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PetypeInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new PetypeDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoJoin getJoinHook(PetypeInfo recordInfo) {
		DaoJoinBuilder joinText = new PetypeDaoJoinTxt(MAIN_TABLE);		
		return joinText.build();
	}	
	
	
	
	@Override protected DaoResultParser<PetypeInfo> getResultParserHook() {
		return new DaoResultParser<PetypeInfo>() {
			@Override public List<PetypeInfo> parseResult(PetypeInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PetypeInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
			
				do {				
					PetypeInfo dataInfo = new PetypeInfo();
					
					dataInfo.codPetype = DaoFormatter.sqlToInt(stmtResult, PetypeDaoDbTableColumn.COL_COD_PET_TYPE);
					dataInfo.txtPetype = stmtResult.getString(PetypeDaoDbTableColumn.COL_NAME);
					dataInfo.codLanguage = stmtResult.getString(PetypeDaoDbTableColumn.COL_COD_LANGUAGE);		
					
					finalResult.add(dataInfo);				
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
