package br.com.mind5.business.employeeMaterial.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmpmatDeleteSingle extends DaoStmtTemplate<EmpmatInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_MAT_TABLE;
	
	
	public EmpmatDeleteSingle(Connection conn, EmpmatInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);		
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SOFT_DELETE;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpmatInfo recordInfo) {		
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;	
		whereOption.ignoreNonPrimaryKey = DaoOptionValue.IGNORE_NON_PK;		
		
		DaoStmtWhere whereClause = new EmpmatWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected DaoResultParserV2<EmpmatInfo> getResultParserHook() {
		return new DaoResultParserV2<EmpmatInfo>() {
			@Override public List<EmpmatInfo> parseResult(EmpmatInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmpmatInfo> finalResult = new ArrayList<>();
				EmpmatInfo emptyInfo = new EmpmatInfo();
				finalResult.add(emptyInfo);			
				return finalResult;
			}
		};
	}
}
