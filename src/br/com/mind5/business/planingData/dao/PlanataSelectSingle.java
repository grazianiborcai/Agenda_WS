package br.com.mind5.business.planingData.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.dao.DaoDictionary;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinColumn;
import br.com.mind5.dao.DaoJoinType;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoStmt;
import br.com.mind5.dao.DaoStmtHelper_;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoDbTableColumnAll;
import br.com.mind5.dao.common.DaoOptionValue;
import br.com.mind5.dao.obsolete.DaoResultParser_;
import br.com.mind5.dao.obsolete.DaoStmtOption_;

public final class PlanataSelectSingle implements DaoStmt<PlanataInfo> {
	private final String LT_STORE = DaoDbTable.STORE_TABLE;
	private final String RT_STORE_WT = DaoDbTable.STORE_WT_TABLE;
	private final String RT_EMP_WT = DaoDbTable.EMP_WT_TABLE;
	private final String RT_EMP_POSITION = DaoDbTable.EMPOS_TABLE;
	private final String RT_EMP_MAT = DaoDbTable.EMP_MAT_TABLE;
	private final String RT_MAT = DaoDbTable.MAT_TABLE;
	private final String RT_MAT_STORE = DaoDbTable.MAT_STORE_TABLE;
	
	private DaoStmt<PlanataInfo> stmtSql;
	private DaoStmtOption_<PlanataInfo> stmtOption;
	
	
	
	public PlanataSelectSingle(Connection conn, PlanataInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, PlanataInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_STORE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.PLANING_DATA_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new PlanataWhere(whereOption, DaoDbTable.PLANING_DATA_VIEW, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinStoreWorkTime());
		joins.add(buildJoinEmployeeWorkTime());
		joins.add(buildJoinEmployeePosition());
		joins.add(buildJoinEmployeeMaterial());
		joins.add(buildJoinMaterial());
		joins.add(buildJoinMaterialStore());
		return joins;
	}
	
	
	
	private DaoJoin buildJoinStoreWorkTime() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_STORE;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_STORE;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_COD_STORE;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_COD_STORE;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_STORE;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_RECORD_MODE;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_RECORD_MODE;
		joinColumns.add(oneColumn);	
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_STORE_WT;
		join.joinType = DaoJoinType.INNER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
	}
	
	
	
	private DaoJoin buildJoinEmployeeWorkTime() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_STORE_WT;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_STORE_WT;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_COD_STORE;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_COD_STORE;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_STORE_WT;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_COD_WEEKDAY;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_COD_WEEKDAY;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_STORE_WT;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_BEGIN_TIME;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_BEGIN_TIME;
		oneColumn.condition = DaoDictionary.LESS_THAN_OR_EQUAL_TO;
		joinColumns.add(oneColumn);		
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_STORE_WT;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_END_TIME;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_END_TIME;
		oneColumn.condition = DaoDictionary.GREATER_THAN_OR_EQUAL_TO;
		joinColumns.add(oneColumn);	
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_STORE_WT;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_RECORD_MODE;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_RECORD_MODE;
		joinColumns.add(oneColumn);		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_EMP_WT;
		join.joinType = DaoJoinType.INNER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
	}
	
	
	
	private DaoJoin buildJoinEmployeePosition() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_EMP_WT;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_EMP_WT;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_COD_STORE;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_COD_STORE;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_EMP_WT;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_COD_EMPLOYEE;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_COD_EMPLOYEE;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_EMP_WT;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_RECORD_MODE;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_RECORD_MODE;
		joinColumns.add(oneColumn);	
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_EMP_POSITION;
		join.joinType = DaoJoinType.INNER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
	}	
	
	
	
	private DaoJoin buildJoinEmployeeMaterial() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_EMP_WT;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_EMP_WT;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_COD_EMPLOYEE;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_COD_EMPLOYEE;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_EMP_WT;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_RECORD_MODE;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_RECORD_MODE;
		joinColumns.add(oneColumn);	
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_EMP_MAT;
		join.joinType = DaoJoinType.INNER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
	}	
	
	
	
	private DaoJoin buildJoinMaterial() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_EMP_MAT;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_EMP_MAT;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_COD_MATERIAL;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_COD_MATERIAL;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_EMP_MAT;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_RECORD_MODE;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_RECORD_MODE;
		joinColumns.add(oneColumn);	
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_MAT;
		join.joinType = DaoJoinType.INNER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
	}	
	
	
	
	private DaoJoin buildJoinMaterialStore() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_EMP_POSITION;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_EMP_POSITION;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_COD_STORE;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_COD_STORE;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_MAT;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_COD_MATERIAL;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_COD_MATERIAL;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = RT_EMP_POSITION;
		oneColumn.leftColumnName = PlanataDbTableColumn.COL_RECORD_MODE;
		oneColumn.rightColumnName = PlanataDbTableColumn.COL_RECORD_MODE;
		joinColumns.add(oneColumn);	
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_MAT_STORE;
		join.joinType = DaoJoinType.INNER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
	}	

	
		
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper_<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
	}
	
	

	@Override public void generateStmt() throws SQLException {
		stmtSql.generateStmt();		
	}

	
	
	@Override public boolean checkStmtGeneration() {
		return stmtSql.checkStmtGeneration();
	}

	
	
	@Override public void executeStmt() throws SQLException {
		stmtSql.executeStmt();
	}

	
	
	@Override public List<PlanataInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<PlanataInfo> getNewInstance() {
		return new PlanataSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<PlanataInfo> {
		//private final boolean NOT_NULL = false;
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<PlanataInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<PlanataInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				PlanataInfo dataInfo = new PlanataInfo();
				dataInfo.codOwner = stmtResult.getLong(PlanataDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(PlanataDbTableColumn.COL_COD_STORE);
				dataInfo.recordMode = stmtResult.getString(PlanataDbTableColumn.COL_RECORD_MODE);
				dataInfo.codWeekday = stmtResult.getInt(PlanataDbTableColumn.COL_COD_WEEKDAY);
				dataInfo.codEmployee = stmtResult.getLong(PlanataDbTableColumn.COL_COD_EMPLOYEE);
				dataInfo.codMat = stmtResult.getLong(PlanataDbTableColumn.COL_COD_MATERIAL);
				
				Time tempTime = stmtResult.getTime(PlanataDbTableColumn.COL_BEGIN_TIME);
				if (tempTime != null)
					dataInfo.beginTime = tempTime.toLocalTime();
				
				tempTime = stmtResult.getTime(PlanataDbTableColumn.COL_END_TIME);
				if (tempTime != null)
					dataInfo.endTime = tempTime.toLocalTime();	
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
