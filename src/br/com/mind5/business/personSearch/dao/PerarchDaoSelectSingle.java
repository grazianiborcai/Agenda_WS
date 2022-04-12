package br.com.mind5.business.personSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PerarchDaoSelectSingle extends DaoStmtTemplate<PerarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PERSON_TABLE;
	
	
	public PerarchDaoSelectSingle(Connection conn, PerarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PERSON_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PerarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PerarchDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<PerarchInfo> getResultParserHook() {
		return new DaoResultParser<PerarchInfo>() {		
			@Override public List<PerarchInfo> parseResult(PerarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PerarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PerarchInfo dataInfo = new PerarchInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, PerarchDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codPerson = DaoFormatter.sqlToLong(stmtResult, PerarchDaoDbTableColumn.COL_COD_PERSON);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, PerarchDaoDbTableColumn.COL_COD_STORE);
					dataInfo.cpf = stmtResult.getString(PerarchDaoDbTableColumn.COL_CPF);
					dataInfo.name = stmtResult.getString(PerarchDaoDbTableColumn.COL_NAME);	
					dataInfo.nameSearch = stmtResult.getString(PerarchDaoDbTableColumn.COL_NAME_SEARCH);
					dataInfo.email = stmtResult.getString(PerarchDaoDbTableColumn.COL_EMAIL);						
					dataInfo.recordMode = stmtResult.getString(PerarchDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.codEntityCateg = stmtResult.getString(PerarchDaoDbTableColumn.COL_COD_ENTITY_CATEG);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, PerarchDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codGender = DaoFormatter.sqlToInt(stmtResult, PerarchDaoDbTableColumn.COL_COD_GENDER);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, PerarchDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToInt(stmtResult, PerarchDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.birthDate = DaoFormatter.sqlToLocalDate(stmtResult, PerarchDaoDbTableColumn.COL_BIRTH_DATE);
					
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
