package br.com.mind5.business.personList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PersolisSelectSingle extends DaoStmtTemplate<PersolisInfo> {
	private final String MAIN_TABLE = DaoDbTable.PERSON_TABLE;
	
	
	public PersolisSelectSingle(Connection conn, PersolisInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PERSON_LIST_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PersolisInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();	
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PersolisWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<PersolisInfo> getResultParserHook() {
		return new DaoResultParserV2<PersolisInfo>() {				
			@Override public List<PersolisInfo> parseResult(PersolisInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PersolisInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PersolisInfo dataInfo = new PersolisInfo();
					
					dataInfo.codOwner = stmtResult.getLong(PersolisDbTableColumn.COL_COD_OWNER);
					dataInfo.codPerson = stmtResult.getLong(PersolisDbTableColumn.COL_COD_PERSON);
					dataInfo.name = stmtResult.getString(PersolisDbTableColumn.COL_NAME);							
					dataInfo.recordMode = stmtResult.getString(PersolisDbTableColumn.COL_RECORD_MODE);	
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, PersolisDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.birthDate = DaoFormatter.sqlToLocalDate(stmtResult, PersolisDbTableColumn.COL_BIRTH_DATE);
					dataInfo.birthYear = DaoFormatter.sqlToInt(stmtResult, PersolisDbTableColumn.COL_BIRTH_YEAR);
					dataInfo.birthMonth = DaoFormatter.sqlToInt(stmtResult, PersolisDbTableColumn.COL_BIRTH_MONTH);
					dataInfo.birthDay = DaoFormatter.sqlToInt(stmtResult, PersolisDbTableColumn.COL_BIRTH_DAY);
					dataInfo.email = stmtResult.getString(PersolisDbTableColumn.COL_EMAIL);	
					dataInfo.cpf = stmtResult.getString(PersolisDbTableColumn.COL_CPF);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
