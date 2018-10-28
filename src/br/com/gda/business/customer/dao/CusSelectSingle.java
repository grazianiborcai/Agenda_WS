package br.com.gda.business.customer.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.address.dao.AddressDbTableColumn;
import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.dao.DaoDbTable;
import br.com.gda.dao.DaoDbTableColumnAll;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;

public final class CusSelectSingle implements DaoStmt<CusInfo> {
	private final String LT_CUSTOMER = DaoDbTable.CUS_TABLE;
	
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
		this.stmtOption.joins = null;
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
				dataInfo.email = stmtResult.getString(CusDbTableColumn.COL_EMAIL);
				dataInfo.phoneNumber1 = stmtResult.getString(CusDbTableColumn.COL_PHONE_1);							
				dataInfo.recordMode = stmtResult.getString(CusDbTableColumn.COL_RECORD_MODE);
				
				stmtResult.getInt(CusDbTableColumn.COL_COD_GENDER);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codGender = stmtResult.getInt(CusDbTableColumn.COL_COD_GENDER);	
				
				stmtResult.getInt(CusDbTableColumn.COL_PHONE_1_COUNTRY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.codCountryPhone1 = stmtResult.getInt(CusDbTableColumn.COL_PHONE_1_COUNTRY);
				
				Timestamp lastChanged = stmtResult.getTimestamp(AddressDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();	
				
				Date tempDate = stmtResult.getDate(CusDbTableColumn.COL_COD_BIRTH_DATE);
				if (tempDate != null)
					dataInfo.birthDate = tempDate.toLocalDate();
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
