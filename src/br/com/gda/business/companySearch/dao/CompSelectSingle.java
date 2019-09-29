package br.com.gda.business.companySearch.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.dao.DaoFormatter;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;
import br.com.gda.dao.common.DaoOptionValue;

public final class CompSelectSingle implements DaoStmt<CompInfo> {
	private final String LT_COMP = DaoDbTable.COMP_TABLE;
	
	private DaoStmt<CompInfo> stmtSql;
	private DaoStmtOption<CompInfo> stmtOption;
	
	
	
	public CompSelectSingle(Connection conn, CompInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, CompInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_COMP;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(LT_COMP);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new CompWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	private void buildStmt() {
		this.stmtSql = new DaoStmtHelper<>(DaoOperation.SELECT, this.stmtOption, this.getClass());
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

	
	
	@Override public List<CompInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<CompInfo> getNewInstance() {
		return new CompSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<CompInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<CompInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {			
			List<CompInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				CompInfo dataInfo = new CompInfo();
				dataInfo.codOwner = stmtResult.getLong(CompDbTableColumn.COL_COD_OWNER);
				dataInfo.codCompany = stmtResult.getLong(CompDbTableColumn.COL_COD_COMPANY);
				dataInfo.cnpj = stmtResult.getString(CompDbTableColumn.COL_CNPJ);
				dataInfo.name = stmtResult.getString(CompDbTableColumn.COL_NAME);			
				dataInfo.email = stmtResult.getString(CompDbTableColumn.COL_EMAIL);						
				dataInfo.recordMode = stmtResult.getString(CompDbTableColumn.COL_RECORD_MODE);
				dataInfo.codEntityCateg = stmtResult.getString(CompDbTableColumn.COL_COD_ENTITY_CATEG);
				dataInfo.codCountryLegal = stmtResult.getString(CompDbTableColumn.COL_COUNTRY_LEGAL);
				dataInfo.inscrEst = stmtResult.getString(CompDbTableColumn.COL_INSC_ESTATUAL);
				dataInfo.inscrMun = stmtResult.getString(CompDbTableColumn.COL_INSC_MUNICIPAL);
				dataInfo.razaoSocial = stmtResult.getString(CompDbTableColumn.COL_RAZAO_SOCIAL);
				dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, CompDbTableColumn.COL_LAST_CHANGED);
				dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, CompDbTableColumn.COL_LAST_CHANGED_BY);
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, CompDbTableColumn.COL_COD_SNAPSHOT);				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
