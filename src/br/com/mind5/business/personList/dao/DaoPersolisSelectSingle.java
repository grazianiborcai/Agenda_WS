package br.com.mind5.business.personList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoPersolisSelectSingle extends DaoStmtTemplate<PersolisInfo> {
	private final String MAIN_TABLE = DaoDbTable.PERSON_TABLE;
	
	
	public DaoPersolisSelectSingle(Connection conn, PersolisInfo recordInfo, String schemaName) {
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
		
		DaoStmtWhere whereClause = new DaoPersolisWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<PersolisInfo> getResultParserHook() {
		return new DaoResultParser<PersolisInfo>() {				
			@Override public List<PersolisInfo> parseResult(PersolisInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PersolisInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PersolisInfo dataInfo = new PersolisInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoPersolisDbTableColumn.COL_COD_OWNER);
					dataInfo.codPerson = stmtResult.getLong(DaoPersolisDbTableColumn.COL_COD_PERSON);
					dataInfo.name = stmtResult.getString(DaoPersolisDbTableColumn.COL_NAME);		
					dataInfo.nameDisplay = stmtResult.getString(DaoPersolisDbTableColumn.COL_NAME_DISPLAY);
					dataInfo.recordMode = stmtResult.getString(DaoPersolisDbTableColumn.COL_RECORD_MODE);	
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoPersolisDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.birthDate = DaoFormatter.sqlToLocalDate(stmtResult, DaoPersolisDbTableColumn.COL_BIRTH_DATE);
					dataInfo.birthYear = DaoFormatter.sqlToInt(stmtResult, DaoPersolisDbTableColumn.COL_BIRTH_YEAR);
					dataInfo.birthMonth = DaoFormatter.sqlToInt(stmtResult, DaoPersolisDbTableColumn.COL_BIRTH_MONTH);
					dataInfo.birthDay = DaoFormatter.sqlToInt(stmtResult, DaoPersolisDbTableColumn.COL_BIRTH_DAY);
					dataInfo.email = stmtResult.getString(DaoPersolisDbTableColumn.COL_EMAIL);	
					dataInfo.cpf = stmtResult.getString(DaoPersolisDbTableColumn.COL_CPF);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
