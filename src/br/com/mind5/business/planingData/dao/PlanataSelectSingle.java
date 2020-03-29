package br.com.mind5.business.planingData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoJoinMat;
import br.com.mind5.dao.common.DaoOptionValue;

public final class PlanataSelectSingle extends DaoStmtTemplate<PlanataInfo> {
	private final String MAIN_TABLE = DaoDbTable.STORE_TABLE;
	private final String RT_STORE_WT = DaoDbTable.STORE_WT_TABLE;
	private final String RT_EMP_WT = DaoDbTable.EMP_WT_TABLE;
	private final String RT_EMP_POSITION = DaoDbTable.EMPOS_TABLE;
	private final String RT_EMP_MAT = DaoDbTable.EMP_MAT_TABLE;
	
	
	public PlanataSelectSingle(Connection conn, PlanataInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected String getLookupTableHook() {
		return DaoDbTable.PLANING_DATA_VIEW;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT_DISTINCT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, PlanataInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PlanataWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook(PlanataInfo recordInfo) {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinStowotm = new PlanataJoinStowotm(MAIN_TABLE);		
		joins.add(joinStowotm.build());
		
		DaoJoinBuilder joinEmpwotm = new PlanataJoinEmpwotm(RT_STORE_WT);		
		joins.add(joinEmpwotm.build());
		
		DaoJoinBuilder joinCalate = new PlanataJoinCalate(RT_STORE_WT);		
		joins.add(joinCalate.build());
		
		DaoJoinBuilder joinEmpos = new PlanataJoinEmpos(RT_EMP_WT);		
		joins.add(joinEmpos.build());
		
		DaoJoinBuilder joinEmpmat = new PlanataJoinEmpmat(RT_EMP_WT);		
		joins.add(joinEmpmat.build());
		
		DaoJoinBuilder joinMat = new DaoJoinMat(RT_EMP_MAT);		
		joins.add(joinMat.build());
		
		DaoJoinBuilder joinMatore = new PlanataJoinMatore(RT_EMP_POSITION);		
		joins.add(joinMatore.build());
		
		return joins;
	}
	
	
	
	@Override protected DaoResultParser<PlanataInfo> getResultParserHook() {
		return new DaoResultParser<PlanataInfo>() {		
			@Override public List<PlanataInfo> parseResult(PlanataInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<PlanataInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					PlanataInfo dataInfo = new PlanataInfo();
					
					dataInfo.codOwner = stmtResult.getLong(PlanataDbTableColumn.COL_COD_OWNER);
					dataInfo.codStore = stmtResult.getLong(PlanataDbTableColumn.COL_COD_STORE);
					dataInfo.recordMode = stmtResult.getString(PlanataDbTableColumn.COL_RECORD_MODE);
					dataInfo.codWeekday = stmtResult.getInt(PlanataDbTableColumn.COL_COD_WEEKDAY);
					dataInfo.codEmployee = stmtResult.getLong(PlanataDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = stmtResult.getLong(PlanataDbTableColumn.COL_COD_MATERIAL);
					dataInfo.beginTime = DaoFormatter.sqlToLocalTime(stmtResult, PlanataDbTableColumn.COL_BEGIN_TIME);
					dataInfo.endTime = DaoFormatter.sqlToLocalTime(stmtResult, PlanataDbTableColumn.COL_END_TIME);		
					dataInfo.date = DaoFormatter.sqlToLocalDate(stmtResult, PlanataDbTableColumn.COL_DATE);
					
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
