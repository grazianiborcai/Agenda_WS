package br.com.mind5.business.materialStoreSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.materialStoreSearch.info.MatorarchInfo;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoJoinMat;
import br.com.mind5.dao.common.DaoJoinStore;
import br.com.mind5.dao.common.DaoOptionValue;

public final class DaoMatorarchSelectSingle extends DaoStmtTemplate<MatorarchInfo> {
	private final String MAIN_TABLE = DaoDbTable.MAT_STORE_TABLE;	
	
	
	public DaoMatorarchSelectSingle(Connection conn, MatorarchInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	protected String getLookupTableHook() {
		return DaoDbTable.MAT_STORE_SEARCH_VIEW;
	}	
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, MatorarchInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new DaoMatorarchWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}	
	
	
	
	@Override protected List<DaoJoin> getJoinsHook(MatorarchInfo recordInfo) {		
		List<DaoJoin> joins = new ArrayList<>();	
		
		DaoJoinBuilder joinStore = new DaoJoinStore(MAIN_TABLE);		
		joins.add(joinStore.build());
		
		DaoJoinBuilder joinMat = new DaoJoinMat(MAIN_TABLE);		
		joins.add(joinMat.build());
		
		return joins;
	}
		
	
	
	@Override protected DaoResultParser<MatorarchInfo> getResultParserHook() {
		return new DaoResultParser<MatorarchInfo>() {
			@Override public List<MatorarchInfo> parseResult(MatorarchInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<MatorarchInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					MatorarchInfo dataInfo = new MatorarchInfo();
					
					dataInfo.codOwner = stmtResult.getLong(DaoMatorarchDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(DaoMatorarchDbTableColumn.COL_COD_STORE);
					dataInfo.codMat = stmtResult.getLong(DaoMatorarchDbTableColumn.COL_COD_MATERIAL);
					dataInfo.recordMode = stmtResult.getString(DaoMatorarchDbTableColumn.COL_RECORD_MODE);
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
}
