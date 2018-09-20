package br.com.gda.business.store.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.MasterDataDbTableColumn;
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
	private final static String LT_ATTR = DaoDbTable.STORE_TABLE;	
	private final static String RT_COUNTRY_TEXT = DaoDbTable.COUNTRY_TEXT_TABLE;
	
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
		this.stmtOption.tableName = LT_ATTR;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_ATTR);
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
		oneColumn.leftTableName = LT_ATTR;
		oneColumn.leftColumnName = MasterDataDbTableColumn.COL_COD_COUNTRY;
		oneColumn.rightColumnName = MasterDataDbTableColumn.COL_COD_COUNTRY;
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
		private final String COUNTRY_TEXT_COLUMN = RT_COUNTRY_TEXT + "." + "Name";
		
		@Override public List<StoreInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {
			List<StoreInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				StoreInfo dataInfo = new StoreInfo();
				dataInfo.codOwner = stmtResult.getLong(StoreDbTableColumn.COL_COD_OWNER);
				dataInfo.codStore = stmtResult.getLong(StoreDbTableColumn.COL_COD_STORE);
				dataInfo.cnpj = stmtResult.getString(StoreDbTableColumn.COL_CNPJ);
				dataInfo.inscrMun = stmtResult.getString(StoreDbTableColumn.COL_INSC_MUNICIPAL);
				dataInfo.inscrEst = stmtResult.getString(StoreDbTableColumn.COL_INSC_ESTATUAL);
				dataInfo.razaoSocial = stmtResult.getString(StoreDbTableColumn.COL_RAZAO_SOCIAL);
				dataInfo.name = stmtResult.getString(StoreDbTableColumn.COL_NAME);
				dataInfo.address1 = stmtResult.getString(StoreDbTableColumn.COL_ADDRESS1);
				dataInfo.address2 = stmtResult.getString(StoreDbTableColumn.COL_ADDRESS2);
				dataInfo.postalCode = stmtResult.getLong(StoreDbTableColumn.COL_COD_POST);
				dataInfo.city = stmtResult.getString(StoreDbTableColumn.COL_CITY);
				dataInfo.codCountry = stmtResult.getString(StoreDbTableColumn.COL_COUNTRY);
				dataInfo.txtCountry = stmtResult.getString(COUNTRY_TEXT_COLUMN);
				dataInfo.stateProvince = stmtResult.getString(StoreDbTableColumn.COL_STATE_PROVINCE);
				dataInfo.phone = stmtResult.getString(StoreDbTableColumn.COL_PHONE);
				dataInfo.codCurr = stmtResult.getString(StoreDbTableColumn.COL_COD_CURR);	
				dataInfo.codPayment = stmtResult.getString(StoreDbTableColumn.COL_COD_PAYMENT);					
				dataInfo.latitude = stmtResult.getDouble(StoreDbTableColumn.COL_LATITUTE);	
				dataInfo.longitude = stmtResult.getDouble(StoreDbTableColumn.COL_LONGITUDE);	
				dataInfo.codTimezone = stmtResult.getString(StoreDbTableColumn.COL_COD_TIME_ZONE);
				dataInfo.recordMode = stmtResult.getString(StoreDbTableColumn.COL_RECORD_MODE);			
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
