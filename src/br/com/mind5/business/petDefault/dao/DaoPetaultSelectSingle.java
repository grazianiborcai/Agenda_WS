package br.com.mind5.business.petDefault.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petDefault.info.PetaultInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoPetaultSelectSingle extends DaoStmtTemplate<PetaultInfo> {
	private final String MAIN_TABLE = DaoDbTable.PET_TABLE;	
	
	
	public DaoPetaultSelectSingle(Connection conn, PetaultInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PET_DEFAULT_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PetaultInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoPetaultWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected DaoResultParser<PetaultInfo> getResultParserHook() {
		return new DaoResultParser<PetaultInfo>() {
			@Override public List<PetaultInfo> parseResult(PetaultInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PetaultInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PetaultInfo dataInfo = new PetaultInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoPetaultDbTableColumn.COL_COD_OWNER);
					dataInfo.codPet = DaoFormatter.sqlToLong(stmtResult, DaoPetaultDbTableColumn.COL_COD_PET);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, DaoPetaultDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.petName = stmtResult.getString(DaoPetaultDbTableColumn.COL_PET_NAME);				
					dataInfo.recordMode = stmtResult.getString(DaoPetaultDbTableColumn.COL_RECORD_MODE);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoPetaultDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.petBirthDate = DaoFormatter.sqlToLocalDate(stmtResult, DaoPetaultDbTableColumn.COL_PET_BIRTH_DATE);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoPetaultDbTableColumn.COL_COD_USER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoPetaultDbTableColumn.COL_COD_STORE);
					dataInfo.isDefault = stmtResult.getBoolean(DaoPetaultDbTableColumn.COL_IS_DEFAULT);			
					
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
