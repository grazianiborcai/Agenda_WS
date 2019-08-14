package br.com.gda.business.companySnapshot.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.companySnapshot.info.CompnapInfo;
import br.com.gda.dao.DaoOperation;
import br.com.gda.dao.DaoResultParser;
import br.com.gda.dao.DaoStmt;
import br.com.gda.dao.DaoStmtHelper;
import br.com.gda.dao.DaoStmtOption;
import br.com.gda.dao.DaoStmtWhere;
import br.com.gda.dao.DaoWhereBuilderOption;
import br.com.gda.dao.common.DaoDbTable;
import br.com.gda.dao.common.DaoDbTableColumnAll;

public final class CompnapSelectSingle implements DaoStmt<CompnapInfo> {
	private final String LT_COMP = DaoDbTable.COMP_SNAPHOT_TABLE;
	
	private DaoStmt<CompnapInfo> stmtSql;
	private DaoStmtOption<CompnapInfo> stmtOption;
	
	
	
	public CompnapSelectSingle(Connection conn, CompnapInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, CompnapInfo recordInfo, String schemaName) {
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
		whereOption.ignoreNull = DaoWhereBuilderOption.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoWhereBuilderOption.IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new CompnapWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
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

	
	
	@Override public List<CompnapInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<CompnapInfo> getNewInstance() {
		return new CompnapSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser<CompnapInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		private final boolean NOT_NULL = false;
		
		@Override public List<CompnapInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {			
			List<CompnapInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET )				
					return finalResult;
			
			do {
				CompnapInfo dataInfo = new CompnapInfo();
				dataInfo.codOwner = stmtResult.getLong(CompnapDbTableColumn.COL_COD_OWNER);
				dataInfo.codCompany = stmtResult.getLong(CompnapDbTableColumn.COL_COD_COMPANY);
				dataInfo.codSnapshot = stmtResult.getLong(CompnapDbTableColumn.COL_COD_SNAPSHOT);
				dataInfo.cnpj = stmtResult.getString(CompnapDbTableColumn.COL_CNPJ);
				dataInfo.name = stmtResult.getString(CompnapDbTableColumn.COL_NAME);			
				dataInfo.email = stmtResult.getString(CompnapDbTableColumn.COL_EMAIL);						
				dataInfo.recordMode = stmtResult.getString(CompnapDbTableColumn.COL_RECORD_MODE);
				dataInfo.codEntityCateg = stmtResult.getString(CompnapDbTableColumn.COL_COD_ENTITY_CATEG);
				dataInfo.codCountryLegal = stmtResult.getString(CompnapDbTableColumn.COL_COUNTRY_LEGAL);
				dataInfo.inscrEst = stmtResult.getString(CompnapDbTableColumn.COL_INSC_ESTATUAL);
				dataInfo.inscrMun = stmtResult.getString(CompnapDbTableColumn.COL_INSC_MUNICIPAL);
				dataInfo.razaoSocial = stmtResult.getString(CompnapDbTableColumn.COL_RAZAO_SOCIAL);
				
				Timestamp lastChanged = stmtResult.getTimestamp(CompnapDbTableColumn.COL_LAST_CHANGED);
				if (lastChanged != null)
					dataInfo.lastChanged = lastChanged.toLocalDateTime();
				
				
				stmtResult.getLong(CompnapDbTableColumn.COL_LAST_CHANGED_BY);
				if (stmtResult.wasNull() == NOT_NULL)
					dataInfo.lastChangedBy = stmtResult.getInt(CompnapDbTableColumn.COL_LAST_CHANGED_BY);
				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
