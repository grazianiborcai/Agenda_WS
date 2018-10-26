package br.com.gda.business.customer.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.business.masterData.dao.MasterDataDbTableColumn;
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

public final class CusSelectSingle implements DaoStmt<CusInfo> {
	private final String LT_CUSTOMER = DaoDbTable.CUS_TABLE;	
	private final String RT_GENDER_TEXT = DaoDbTable.GENDER_TEXT_TABLE;
	private final String RT_COUNTRY_TEXT = DaoDbTable.COUNTRY_TEXT_TABLE;
	
	private DaoStmt<CusInfo> stmtSql;
	private DaoStmtOption<CusInfo> stmtOption;
	
	
	
	public CusSelectSingle(Connection conn, CusInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, CusInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_CUSTOMER;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_CUSTOMER);
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
		
		DaoStmtWhere whereClause = new CusWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();
		
		joins.add(buildJoinGenderText());
		joins.add(buildJoinCountryText());
		
		return joins;
	}
	
	
	
	private DaoJoin buildJoinGenderText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_CUSTOMER;
		oneColumn.leftColumnName = CusDbTableColumn.COL_COD_GENDER;
		oneColumn.rightColumnName = CusDbTableColumn.COL_COD_GENDER;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_GENDER_TEXT;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RT_GENDER_TEXT);
		
		return join;
	}
	
	
	
	private DaoJoin buildJoinCountryText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LT_CUSTOMER;
		oneColumn.leftColumnName = CusDbTableColumn.COL_COD_COUNTRY;
		oneColumn.rightColumnName = CusDbTableColumn.COL_COD_COUNTRY;
		joinColumns.add(oneColumn);
		
		
		DaoJoin join = new DaoJoin();
		join.rightTableName = RT_COUNTRY_TEXT;
		join.joinType = DaoJoinType.LEFT_OUTER_JOIN;
		join.joinColumns = joinColumns;
		join.constraintClause = buildJoinConstraintText(RT_COUNTRY_TEXT);
		
		return join;
	}
	
	
	
	private String buildJoinConstraintText(String rightTableName) {
		StringBuilder constrainClause = new StringBuilder(); 
		
		constrainClause.append(rightTableName);
		constrainClause.append(DaoDictionary.PERIOD);
		constrainClause.append(MasterDataDbTableColumn.COL_COD_LANGUAGE);
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

	
	
	@Override public List<CusInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<CusInfo> getNewInstance() {
		return new CusSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<CusInfo> {
		private final boolean NOT_NULL = false;
		
		private final boolean EMPTY_RESULT_SET = false;
		private final String COL_TXT_GENDER = DaoDbTable.GENDER_TEXT_TABLE + "." + CusDbTableColumn.COL_NAME_GENDER;
		private final String COL_TXT_COUNTRY = DaoDbTable.COUNTRY_TEXT_TABLE + "." + CusDbTableColumn.COL_NAME_COUNTRY;
		
		@Override public List<CusInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<CusInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				CusInfo dataInfo = new CusInfo();
				dataInfo.codOwner = stmtResult.getLong(CusDbTableColumn.COL_COD_OWNER);
				dataInfo.codCustomer = stmtResult.getLong(CusDbTableColumn.COL_COD_CUSTOMER);
				dataInfo.cpf = stmtResult.getString(CusDbTableColumn.COL_CPF);
				dataInfo.name = stmtResult.getString(CusDbTableColumn.COL_NAME);
				dataInfo.codGender = stmtResult.getInt(CusDbTableColumn.COL_COD_GENDER);
				dataInfo.txtGender = stmtResult.getString(COL_TXT_GENDER);
				dataInfo.email = stmtResult.getString(CusDbTableColumn.COL_EMAIL);
				dataInfo.address1 = stmtResult.getString(CusDbTableColumn.COL_ADDRESS_1);
				dataInfo.address2 = stmtResult.getString(CusDbTableColumn.COL_ADDRESS_2);
				dataInfo.postalCode = stmtResult.getString(CusDbTableColumn.COL_POSTAL_CODE);
				dataInfo.city = stmtResult.getString(CusDbTableColumn.COL_COD_CITY);
				dataInfo.phoneNumber1 = stmtResult.getString(CusDbTableColumn.COL_PHONE_1);
				dataInfo.codCountry = stmtResult.getString(CusDbTableColumn.COL_COD_COUNTRY);
				dataInfo.txtCountry = stmtResult.getString(COL_TXT_COUNTRY);
				dataInfo.stateProvince = stmtResult.getString(CusDbTableColumn.COL_COD_STATE_PROVINCE);								
				dataInfo.recordMode = stmtResult.getString(CusDbTableColumn.COL_RECORD_MODE);
				
				//TODO: verificar se numero nulo antes de atribuir. Ajustar todo o workspace
				stmtResult.getInt(CusDbTableColumn.COL_PHONE_1_COUNTRY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCountryPhone1 = stmtResult.getInt(CusDbTableColumn.COL_PHONE_1_COUNTRY);
				
				Date tempDate = stmtResult.getDate(CusDbTableColumn.COL_COD_BIRTH_DATE);
				if (tempDate != null)
					dataInfo.birthDate = tempDate.toLocalDate();				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
