package br.com.gda.business.store.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.info.StoreInfo;
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

public final class StoreSelectSingle implements DaoStmt<StoreInfo> {
	private final String LEFT_TABLE_STORE = DaoDbTable.STORE_TABLE;	
	private final String RIGHT_TABLE_COUNTRY_TEXT = DaoDbTable.COUNTRY_TEXT_TABLE;
	
	private DaoStmt<StoreInfo> stmtSql;
	private DaoStmtOption<StoreInfo> stmtOption;
	
	
	
	public StoreSelectSingle(Connection conn, StoreInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, StoreInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LEFT_TABLE_STORE;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LEFT_TABLE_STORE);
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
		
		DaoStmtWhere whereClause = new StoreWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private List<DaoJoin> buildJoins() {
		List<DaoJoin> joins = new ArrayList<>();		
		joins.add(buildJoinCountryText());		
		return joins;
	}
	
	
	
	private DaoJoin buildJoinCountryText() {
		List<DaoJoinColumn> joinColumns = new ArrayList<>();
		
		DaoJoinColumn oneColumn = new DaoJoinColumn();
		oneColumn.leftTableName = LEFT_TABLE_STORE;
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

	
	
	@Override public List<StoreInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<StoreInfo> getNewInstance() {
		return new StoreSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<StoreInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final String COUNTRY_TEXT_COLUMN = DaoDbTable.COUNTRY_TEXT_TABLE + "." + "Name";
		
		@Override public List<StoreInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StoreInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				StoreInfo dataInfo = new StoreInfo();
				dataInfo.codOwner = stmtResult.getLong("cod_owner");
				dataInfo.codStore = stmtResult.getLong("Cod_store");
				dataInfo.cnpj = stmtResult.getString("CNPJ");
				dataInfo.inscrMun = stmtResult.getString("Inscricao_municipal");
				dataInfo.inscrEst = stmtResult.getString("Inscricao_estadual");
				dataInfo.razaoSocial = stmtResult.getString("Razao_social");
				dataInfo.name = stmtResult.getString("Name");
				dataInfo.address1 = stmtResult.getString("Address1");
				dataInfo.address2 = stmtResult.getString("Address2");
				dataInfo.postalCode = stmtResult.getLong("Postalcode");
				dataInfo.city = stmtResult.getString("City");
				dataInfo.codCountry = stmtResult.getString("Country");
				dataInfo.txtCountry = stmtResult.getString(COUNTRY_TEXT_COLUMN);
				dataInfo.stateProvince = stmtResult.getString("State_province");
				dataInfo.phone = stmtResult.getString("Phone");
				dataInfo.codCurr = stmtResult.getString("Cod_curr");	
				dataInfo.codPayment = stmtResult.getString("Cod_payment");					
				dataInfo.latitude = stmtResult.getDouble("Latitude");	
				dataInfo.longitude = stmtResult.getDouble("Longitude");	
				dataInfo.codTimezone = stmtResult.getString("Cod_timezone");
				dataInfo.recordMode = stmtResult.getString("record_mode");			
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
