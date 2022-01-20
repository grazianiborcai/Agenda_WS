package br.com.mind5.business.petSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petSearch.info.PetarchInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoPetarchSelectSingle extends DaoStmtTemplate<PetarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.PET_TABLE;
	
	
	public DaoPetarchSelectSingle(Connection conn, PetarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PET_SEARCH_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PetarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoPetarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<PetarchInfo> getResultParserHook() {
		return new DaoResultParser<PetarchInfo>() {		
			@Override public List<PetarchInfo> parseResult(PetarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PetarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PetarchInfo dataInfo = new PetarchInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoPetarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codPet = DaoFormatter.sqlToLong(stmtResult, DaoPetarchDbTableColumn.COL_COD_PET);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, DaoPetarchDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.petName = stmtResult.getString(DaoPetarchDbTableColumn.COL_PET_NAME);				
					dataInfo.recordMode = stmtResult.getString(DaoPetarchDbTableColumn.COL_RECORD_MODE);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoPetarchDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.petBirthDate = DaoFormatter.sqlToLocalDate(stmtResult, DaoPetarchDbTableColumn.COL_PET_BIRTH_DATE);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoPetarchDbTableColumn.COL_COD_USER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoPetarchDbTableColumn.COL_COD_STORE);
					
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
