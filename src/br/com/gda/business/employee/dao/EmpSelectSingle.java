package br.com.gda.business.employee.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.sql.SqlDbTable;
import br.com.gda.sql.SqlDbTableColumnAll;
import br.com.gda.sql.SqlDictionary;
import br.com.gda.sql.SqlJoin;
import br.com.gda.sql.SqlJoinColumn;
import br.com.gda.sql.SqlJoinType;
import br.com.gda.sql.SqlOperation;
import br.com.gda.sql.SqlResultParser;
import br.com.gda.sql.SqlStmt;
import br.com.gda.sql.SqlStmtHelper;
import br.com.gda.sql.SqlStmtOption;
import br.com.gda.sql.SqlStmtWhere;
import br.com.gda.sql.SqlWhereBuilderOption;

public final class EmpSelectSingle implements SqlStmt<EmpInfo> {
	private final String LEFT_TABLE_EMPLOYEE = SqlDbTable.EMP_TABLE;	
	private final String RIGHT_TABLE_GENDER_TEXT = SqlDbTable.GENDER_TEXT_TABLE;
	private final String RIGHT_TABLE_POSITION_TEXT = SqlDbTable.POSITION_TEXT_TABLE;
	private final String RIGHT_TABLE_COUNTRY_TEXT = SqlDbTable.COUNTRY_TEXT_TABLE;
	
	private SqlStmt<EmpInfo> stmtSql;
	private SqlStmtOption<EmpInfo> stmtOption;
	
	
	
	public EmpSelectSingle(Connection conn, EmpInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, EmpInfo recordInfo, String schemaName) {
		this.stmtOption = new SqlStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LEFT_TABLE_EMPLOYEE;
		this.stmtOption.columns = SqlDbTableColumnAll.getTableColumnsAsList(LEFT_TABLE_EMPLOYEE);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		SqlWhereBuilderOption whereOption = new SqlWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		SqlStmtWhere whereClause = new EmpWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<SqlJoin> buildJoins() {
		List<SqlJoin> joins = new ArrayList<>();
		
		joins.add(buildJoinGenderText());
		joins.add(buildJoinPositionText());
		joins.add(buildJoinCountryText());
		
		return joins;
	}
	
	
	
	private SqlJoin buildJoinGenderText() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LEFT_TABLE_EMPLOYEE;
		oneColumn.leftColumnName = "Cod_gender";
		oneColumn.rightColumnName = "Cod_gender";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		join.rightTableName = RIGHT_TABLE_GENDER_TEXT;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RIGHT_TABLE_GENDER_TEXT);
		
		return join;
	}
	
	
	
	private SqlJoin buildJoinPositionText() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LEFT_TABLE_EMPLOYEE;
		oneColumn.leftColumnName = "Cod_position";
		oneColumn.rightColumnName = "Cod_position";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		join.rightTableName = RIGHT_TABLE_POSITION_TEXT;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RIGHT_TABLE_POSITION_TEXT);
		
		return join;
	}
	
	
	
	private SqlJoin buildJoinCountryText() {
		List<SqlJoinColumn> joinColumns = new ArrayList<>();
		
		SqlJoinColumn oneColumn = new SqlJoinColumn();
		oneColumn.leftTableName = LEFT_TABLE_EMPLOYEE;
		oneColumn.leftColumnName = "Country";
		oneColumn.rightColumnName = "Country";
		joinColumns.add(oneColumn);
		
		
		SqlJoin join = new SqlJoin();
		join.rightTableName = RIGHT_TABLE_COUNTRY_TEXT;
		join.joinType = SqlJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RIGHT_TABLE_COUNTRY_TEXT);
		
		return join;
	}
	
	
	
	private String buildJoinConstraintText(String rightTableName) {
		StringBuilder constrainClause = new StringBuilder(); 
		
		constrainClause.append(rightTableName);
		constrainClause.append(SqlDictionary.PERIOD);
		constrainClause.append("Language");
		constrainClause.append(SqlDictionary.SPACE);
		constrainClause.append(SqlDictionary.EQUAL);
		constrainClause.append(SqlDictionary.SPACE);
		constrainClause.append(SqlDictionary.QUOTE);
		constrainClause.append(this.stmtOption.recordInfo.codLanguage);
		constrainClause.append(SqlDictionary.QUOTE);
		
		return constrainClause.toString();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new SqlStmtHelper<>(SqlOperation.SELECT, this.stmtOption);
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

	
	
	@Override public List<EmpInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public SqlStmt<EmpInfo> getNewInstance() {
		return new EmpSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements SqlResultParser<EmpInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String GENDER_TEXT_COLUMN = SqlDbTable.GENDER_TEXT_TABLE + "." + "Name";
		private final String POSITION_TEXT_COLUMN = SqlDbTable.POSITION_TEXT_TABLE + "." + "Name";
		private final String COUNTRY_TEXT_COLUMN = SqlDbTable.COUNTRY_TEXT_TABLE + "." + "Name";
		
		@Override public List<EmpInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<EmpInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				EmpInfo dataInfo = new EmpInfo();
				dataInfo.codOwner = stmtResult.getLong("cod_owner");
				dataInfo.codEmployee = stmtResult.getLong("cod_employee");
				dataInfo.cpf = stmtResult.getString("CPF");
				dataInfo.name = stmtResult.getString("Name");
				dataInfo.codGender = stmtResult.getInt("Cod_gender");
				dataInfo.txtGender = stmtResult.getString(GENDER_TEXT_COLUMN);
				dataInfo.email = stmtResult.getString("Email");
				dataInfo.address1 = stmtResult.getString("Address1");
				dataInfo.address2 = stmtResult.getString("Address2");
				dataInfo.postalCode = stmtResult.getLong("Postalcode");
				dataInfo.city = stmtResult.getString("City");
				dataInfo.codCountry = stmtResult.getString("Country");
				dataInfo.txtCountry = stmtResult.getString(COUNTRY_TEXT_COLUMN);
				dataInfo.stateProvince = stmtResult.getString("State_province");
				dataInfo.phone = stmtResult.getString("Phone");
				dataInfo.codPosition = stmtResult.getLong("Cod_position");	
				dataInfo.txtPosition = stmtResult.getString(POSITION_TEXT_COLUMN);	
				dataInfo.recordMode = stmtResult.getString("record_mode");
				
				Time tempTime = stmtResult.getTime("begin_time");
				if (tempTime != null)
					dataInfo.beginTime = tempTime.toLocalTime();
				
				tempTime = stmtResult.getTime("end_time");
				if (tempTime != null)
					dataInfo.endTime = tempTime.toLocalTime();
				
				Date tempDate = stmtResult.getDate("Born_date");
				if (tempDate != null)
					dataInfo.birthDate = tempDate.toLocalDate();				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
