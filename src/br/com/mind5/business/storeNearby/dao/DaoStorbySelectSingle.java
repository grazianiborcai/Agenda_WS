package br.com.mind5.business.storeNearby.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoJoinComp;
import br.com.mind5.dao.common.DaoJoinStore;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoStorbySelectSingle extends DaoStmtTemplate<StorbyInfo> {
	private final String MAIN_TABLE = DaoDbTable.ADDRESS_TABLE;	
	private final String STORE_TABLE = DaoDbTable.STORE_TABLE;	
	
	
	public DaoStorbySelectSingle(Connection conn, StorbyInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.STORE_NEARBY_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, StorbyInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;
		
		DaoStmtWhere whereClause = new DaoStorbyWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook(StorbyInfo recordInfo) {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinStore = new DaoJoinStore(MAIN_TABLE);		
		joins.add(joinStore.build());
		
		DaoJoinBuilder joinComp = new DaoJoinComp(STORE_TABLE);		
		joins.add(joinComp.build());
		
		return joins;
	}
	
	
	
	@Override protected DaoResultParser<StorbyInfo> getResultParserHook() {
		return new DaoResultParser<StorbyInfo>() {
			@Override public List<StorbyInfo> parseResult(StorbyInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<StorbyInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					StorbyInfo dataInfo = new StorbyInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoStorbyDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(DaoStorbyDbTableColumn.COL_COD_STORE);
					dataInfo.codCompany = stmtResult.getLong(DaoStorbyDbTableColumn.COL_COD_COMPANY);
					dataInfo.districtSearch = stmtResult.getString(DaoStorbyDbTableColumn.COL_DISTRICT_SEARCH);
					dataInfo.nameSearch = stmtResult.getString(DaoStorbyDbTableColumn.COL_NAME_SEARCH);
					dataInfo.recordMode = stmtResult.getString(DaoStorbyDbTableColumn.COL_RECORD_MODE);	
					dataInfo.geoHash01 = stmtResult.getString(DaoStorbyDbTableColumn.COL_GEO_HASH_01);
					dataInfo.geoHash02 = stmtResult.getString(DaoStorbyDbTableColumn.COL_GEO_HASH_02);
					dataInfo.geoHash03 = stmtResult.getString(DaoStorbyDbTableColumn.COL_GEO_HASH_03);
					
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
