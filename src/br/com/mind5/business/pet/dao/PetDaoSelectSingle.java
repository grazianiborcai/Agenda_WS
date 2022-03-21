package br.com.mind5.business.pet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.pet.info.PetInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PetDaoSelectSingle extends DaoStmtTemplate<PetInfo> {
	private final String MAIN_TABLE = DaoDbTable.PET_TABLE;
	
	
	public PetDaoSelectSingle(Connection conn, PetInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PetInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PetDaoWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<PetInfo> getResultParserHook() {
		return new DaoResultParser<PetInfo>() {
			@Override public List<PetInfo> parseResult(PetInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PetInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PetInfo dataInfo = new PetInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, PetDaoDbTableColumn.COL_COD_OWNER);
					dataInfo.codPet = DaoFormatter.sqlToLong(stmtResult, PetDaoDbTableColumn.COL_COD_PET);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, PetDaoDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codPeteight = DaoFormatter.sqlToInt(stmtResult, PetDaoDbTableColumn.COL_COD_PET_WEIGHT);
					dataInfo.codPetype = DaoFormatter.sqlToInt(stmtResult, PetDaoDbTableColumn.COL_COD_PET_TYPE);
					dataInfo.petName = stmtResult.getString(PetDaoDbTableColumn.COL_PET_NAME);
					dataInfo.petNote = stmtResult.getString(PetDaoDbTableColumn.COL_PET_NOTES);
					dataInfo.recordMode = stmtResult.getString(PetDaoDbTableColumn.COL_RECORD_MODE);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, PetDaoDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, PetDaoDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, PetDaoDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, PetDaoDbTableColumn.COL_CREATED_BY);
					dataInfo.petBirthDate = DaoFormatter.sqlToLocalDate(stmtResult, PetDaoDbTableColumn.COL_PET_BIRTH_DATE);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, PetDaoDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, PetDaoDbTableColumn.COL_COD_USER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, PetDaoDbTableColumn.COL_COD_STORE);
					dataInfo.isDefault = stmtResult.getBoolean(PetDaoDbTableColumn.COL_IS_DEFAULT);
					
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
