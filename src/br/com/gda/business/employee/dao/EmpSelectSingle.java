package br.com.gda.business.employee.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoDictionary;
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

public final class EmpSelectSingle implements DaoStmt<EmpInfo> {
	private final String LEFT_TABLE_EMPLOYEE = DaoDbTable.EMP_TABLE;	
	private final String RIGHT_TABLE_GENDER_TEXT = DaoDbTable.GENDER_TEXT_TABLE;
	private final String RIGHT_TABLE_POSITION_TEXT = DaoDbTable.POSITION_TEXT_TABLE;
	private final String RIGHT_TABLE_COUNTRY_TEXT = DaoDbTable.COUNTRY_TEXT_TABLE;
	
	private DaoStmt<EmpInfo> stmtSql;
	private DaoStmtOption<EmpInfo> stmtOption;
	
	
	
	public EmpSelectSingle(Connection conn, EmpInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, EmpInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LEFT_TABLE_EMPLOYEE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LEFT_TABLE_EMPLOYEE);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = buildJoins();
	}
	
	
	
	private String buildWhereClause() {
		final boolean IGNORE_NULL = true;
		final boolean DONT_IGNORE_RECORD_MODE = false;
		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = IGNORE_NULL;
		whereOption.ignoreRecordMode = DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();
		
		joins.add(buildJoinGenderText());
		joins.add(buildJoinPositionText());
		joins.add(buildJoinCountryText());
		
		return joins;
	}
	
	
	
	private DaoJoin buildJoinGenderText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LEFT_TABLE_EMPLOYEE;
		oneColumn.leftColumnName = "Cod_gender";
		oneColumn.rightColumnName = "Cod_gender";
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RIGHT_TABLE_GENDER_TEXT;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RIGHT_TABLE_GENDER_TEXT);
		
		return join;
	}
	
	
	
	private DaoJoin buildJoinPositionText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LEFT_TABLE_EMPLOYEE;
		oneColumn.leftColumnName = "Cod_position";
		oneColumn.rightColumnName = "Cod_position";
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RIGHT_TABLE_POSITION_TEXT;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RIGHT_TABLE_POSITION_TEXT);
		
		return join;
	}
	
	
	
	private DaoJoin buildJoinCountryText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LEFT_TABLE_EMPLOYEE;
		oneColumn.leftColumnName = "Country";
		oneColumn.rightColumnName = "Country";
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RIGHT_TABLE_COUNTRY_TEXT;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RIGHT_TABLE_COUNTRY_TEXT);
		
		return join;
	}
	
	
	
	private String buildJoinConstraintText(String rightTableName) {
		StringBuilder constrainClause = new StringBuilder(); 
		
		constrainClause.append(rightTableName);
		constrainClause.append(DaoDictionary.PERIOD);
		constrainClause.append("Language");
		constrainClause.append(DaoDictionary.SPACE);
		constrainClause.append(DaoDictionary.EQUAL);
		constrainClause.append(DaoDictionary.SPACE);
		constrainClause.append(DaoDictionary.QUOTE);
		constrainClause.append(this.stmtOption.recordInfo.codLanguage);
		constrainClause.append(DaoDictionary.QUOTE);
		
		return constrainClause.toString();
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

	
	
	@Override public List<EmpInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<EmpInfo> getNewInstance() {
		return new EmpSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<EmpInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String GENDER_TEXT_COLUMN = DaoDbTable.GENDER_TEXT_TABLE + "." + "Name";
		private final String POSITION_TEXT_COLUMN = DaoDbTable.POSITION_TEXT_TABLE + "." + "Name";
		private final String COUNTRY_TEXT_COLUMN = DaoDbTable.COUNTRY_TEXT_TABLE + "." + "Name";
		
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
