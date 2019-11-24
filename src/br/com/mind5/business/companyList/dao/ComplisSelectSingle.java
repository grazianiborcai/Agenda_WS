package br.com.mind5.business.companyList.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.companyList.info.ComplisInfo;
import br.com.mind5.dao.DaoFormatter;
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

public final class ComplisSelectSingle implements DaoStmt<ComplisInfo> {
	private final String LT_COMP = DaoDbTable.COMP_TABLE;
	
	private DaoStmt<ComplisInfo> stmtSql;
	private DaoStmtOption_<ComplisInfo> stmtOption;
	
	
	
	public ComplisSelectSingle(Connection conn, ComplisInfo recordInfo, String schemaName) {
		buildStmtOption(conn, recordInfo, schemaName);
		buildStmt();
	}
	
	
	
	private void buildStmtOption(Connection conn, ComplisInfo recordInfo, String schemaName) {
		this.stmtOption = new DaoStmtOption_<>();
		this.stmtOption.conn = conn;
		this.stmtOption.recordInfo = recordInfo;
		this.stmtOption.schemaName = schemaName;
		this.stmtOption.tableName = LT_COMP;
		this.stmtOption.columns = DaoDbTableColumnAll.getTableColumnsAsList(DaoDbTable.COMPANY_LIST_VIEW);
		this.stmtOption.stmtParamTranslator = null;
		this.stmtOption.resultParser = new ResultParser();
		this.stmtOption.whereClause = buildWhereClause();
		this.stmtOption.joins = null;
	}
	
	
	
	private String buildWhereClause() {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new ComplisWhere(whereOption, stmtOption.tableName, stmtOption.recordInfo);
		return whereClause.getWhereClause();
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

	
	
	@Override public List<ComplisInfo> getResultset() {
		return stmtSql.getResultset();
	}
	
	
	
	@Override public DaoStmt<ComplisInfo> getNewInstance() {
		return new ComplisSelectSingle(stmtOption.conn, stmtOption.recordInfo, stmtOption.schemaName);
	}
	
	
	
	
	
	
	private static class ResultParser implements DaoResultParser_<ComplisInfo> {
		private final boolean EMPTY_RESULT_SET = false;
		
		@Override public List<ComplisInfo> parseResult(ResultSet stmtResult, long lastId) throws SQLException {			
			List<ComplisInfo> finalResult = new ArrayList<>();
			
			if (stmtResult.next() == EMPTY_RESULT_SET)				
				return finalResult;
			
			do {
				ComplisInfo dataInfo = new ComplisInfo();
				dataInfo.codOwner = stmtResult.getLong(ComplisDbTableColumn.COL_COD_OWNER);
				dataInfo.codCompany = stmtResult.getLong(ComplisDbTableColumn.COL_COD_COMPANY);
				dataInfo.name = stmtResult.getString(ComplisDbTableColumn.COL_NAME);			
				dataInfo.email = stmtResult.getString(ComplisDbTableColumn.COL_EMAIL);						
				dataInfo.recordMode = stmtResult.getString(ComplisDbTableColumn.COL_RECORD_MODE);
				dataInfo.razaoSocial = stmtResult.getString(ComplisDbTableColumn.COL_RAZAO_SOCIAL);
				dataInfo.codSnapshot = DaoFormatter.sqlToLong(stmtResult, ComplisDbTableColumn.COL_COD_SNAPSHOT);				
				
				finalResult.add(dataInfo);
			} while (stmtResult.next());
			
			return finalResult;
		}
	}
}
