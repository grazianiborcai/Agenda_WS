package br.com.mind5.business.petSnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.petSnapshot.info.PetsnapInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoPetsnapSelectSingle extends DaoStmtTemplate<PetsnapInfo> {
	private final String MAIN_TABLE = DaoDbTable.PET_SNAPSHOT_TABLE;
	
	
	public DaoPetsnapSelectSingle(Connection conn, PetsnapInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PetsnapInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoPetsnapWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<PetsnapInfo> getResultParserHook() {
		return new DaoResultParser<PetsnapInfo>() {
			@Override public List<PetsnapInfo> parseResult(PetsnapInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PetsnapInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PetsnapInfo dataInfo = new PetsnapInfo();
					
					dataInfo.codOwner = DaoFormatter.sqlToLong(stmtResult, DaoPetsnapDbTableColumn.COL_COD_OWNER);
					dataInfo.codPet = DaoFormatter.sqlToLong(stmtResult, DaoPetsnapDbTableColumn.COL_COD_PET);
					dataInfo.codCustomer = DaoFormatter.sqlToLong(stmtResult, DaoPetsnapDbTableColumn.COL_COD_CUSTOMER);
					dataInfo.codPeteight = DaoFormatter.sqlToInt(stmtResult, DaoPetsnapDbTableColumn.COL_COD_PET_WEIGHT);
					dataInfo.codPetype = DaoFormatter.sqlToInt(stmtResult, DaoPetsnapDbTableColumn.COL_COD_PET_TYPE);
					dataInfo.petName = stmtResult.getString(DaoPetsnapDbTableColumn.COL_PET_NAME);
					dataInfo.petNote = stmtResult.getString(DaoPetsnapDbTableColumn.COL_PET_NOTES);
					dataInfo.recordMode = stmtResult.getString(DaoPetsnapDbTableColumn.COL_RECORD_MODE);
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoPetsnapDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, DaoPetsnapDbTableColumn.COL_LAST_CHANGED_BY);
					dataInfo.createdOn = DaoFormatter.sqlToLocalDateTime(stmtResult, DaoPetsnapDbTableColumn.COL_CREATED_ON);
					dataInfo.createdBy = DaoFormatter.sqlToLong(stmtResult, DaoPetsnapDbTableColumn.COL_CREATED_BY);
					dataInfo.petBirthDate = DaoFormatter.sqlToLocalDate(stmtResult, DaoPetsnapDbTableColumn.COL_PET_BIRTH_DATE);
					dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, DaoPetsnapDbTableColumn.COL_COD_SNAPSHOT);
					dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, DaoPetsnapDbTableColumn.COL_COD_USER);
					dataInfo.codStore = DaoFormatter.sqlToLong(stmtResult, DaoPetsnapDbTableColumn.COL_COD_STORE);
					dataInfo.isDefault = stmtResult.getBoolean(DaoPetsnapDbTableColumn.COL_IS_DEFAULT);
					
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
