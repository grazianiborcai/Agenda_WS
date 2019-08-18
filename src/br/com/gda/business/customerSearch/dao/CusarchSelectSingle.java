package br.com.gda.business.customerSearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoJoin;
import br.com.gda.dao.DaoJoinColumn;
import br.com.gda.dao.DaoJoinType;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class CusarchSelectSingle implements DaoStmt<CusarchInfo> {
	private final String LT_CUS = DaoDbTable.CUS_TABLE;
	private final String RT_PERSON = DaoDbTable.PERSON_TABLE;	
	private final String RT_PHONE = DaoDbTable.PHONE_TABLE;	
	
	private DaoStmt<CusarchInfo> stmtSql;
	private DaoStmtOption<CusarchInfo> stmtOption;
	
	
	
	public CusarchSelectSingle(Connection conn, CusarchInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();		
	}
	
	
	
	private void buildStmtOption(Connection conn, CusarchInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_CUS;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.CUS_SEARCH_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.DONT_IGNORE_RECORD_MODE;	
		
		DaoStmtWhere whereClause = new CusarchWhere(whereOption, DaoDbTable.CUS_SEARCH_VIEW, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinPerson());
		joins.add(buildJoinPhone());	
		return joins;
	}
	
	
	
	private DaoJoin buildJoinPerson() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_CUS;
		oneColumn.leftColumnName = CusarchDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = CusarchDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_CUS;
		oneColumn.leftColumnName = CusarchDbTableColumn.COL_COD_PERSON;
		oneColumn.rightColumnName = CusarchDbTableColumn.COL_COD_PERSON;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_CUS;
		oneColumn.leftColumnName = CusarchDbTableColumn.COL_RECORD_MODE;
		oneColumn.rightColumnName = CusarchDbTableColumn.COL_RECORD_MODE;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_PERSON;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
	}
	
	
	
	private DaoJoin buildJoinPhone() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_CUS;
		oneColumn.leftColumnName = CusarchDbTableColumn.COL_COD_OWNER;
		oneColumn.rightColumnName = CusarchDbTableColumn.COL_COD_OWNER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_CUS;
		oneColumn.leftColumnName = CusarchDbTableColumn.COL_COD_CUSTOMER;
		oneColumn.rightColumnName = CusarchDbTableColumn.COL_COD_CUSTOMER;
		joinColumns.add(oneColumn);
		
		oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_CUS;
		oneColumn.leftColumnName = CusarchDbTableColumn.COL_RECORD_MODE;
		oneColumn.rightColumnName = CusarchDbTableColumn.COL_RECORD_MODE;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_PHONE;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = null;
		
		return join;
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption);
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

	
	
	@Override public List<CusarchInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<CusarchInfo> getNewInstance() {
		return new CusarchSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	private class ResultParser implements DaoResultParser<CusarchInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		
		@Override public List<CusarchInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<CusarchInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
				return finalResult;
		
			do {				
				CusarchInfo dataInfo = new CusarchInfo();
				dataInfo.codOwner = stmtResult.getLong(CusarchDbTableColumn.COL_COD_OWNER);
				dataInfo.codCustomer = stmtResult.getLong(CusarchDbTableColumn.COL_COD_CUSTOMER);	
				dataInfo.recordMode = stmtResult.getString(CusarchDbTableColumn.COL_RECORD_MODE);
				dataInfo.codUser = DaoFormatter.sqlToLong(stmtResult, CusarchDbTableColumn.COL_COD_USER);
				
				finalResult.add(dataInfo);				
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
