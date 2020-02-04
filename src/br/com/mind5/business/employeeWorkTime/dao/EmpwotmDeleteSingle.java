package br.com.mind5.business.employeeWorkTime.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParser;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmpwotmDeleteSingle extends DaoStmtTemplate<EmpwotmInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_WT_TABLE;	
	
	
	public EmpwotmDeleteSingle(Connection conn, EmpwotmInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpwotmInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;
		
		DaoStmtWhere whereClause = new EmpwotmWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParser<EmpwotmInfo> getResultParserHook() {
		return new DaoResultParser<EmpwotmInfo>() {
			@Override public List<EmpwotmInfo> parseResult(EmpwotmInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmpwotmInfo> finalResult = new ArrayList<>();
				EmpwotmInfo emptyInfo = new EmpwotmInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
