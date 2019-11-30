package br.com.mind5.business.employeeMaterial.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.dao.DaoFormatter;
import br.com.mind5.dao.DaoJoin;
import br.com.mind5.dao.DaoJoinBuilder;
import br.com.mind5.dao.DaoOperation;
import br.com.mind5.dao.DaoResultParserV2;
import br.com.mind5.dao.DaoStmtTemplate;
import br.com.mind5.dao.DaoStmtWhere;
import br.com.mind5.dao.DaoWhereBuilderOption;
import br.com.mind5.dao.common.DaoDbTable;
import br.com.mind5.dao.common.DaoJoinEmp;
import br.com.mind5.dao.common.DaoJoinMat;
import br.com.mind5.dao.common.DaoOptionValue;

public final class EmpmatSelectSingle extends DaoStmtTemplate<EmpmatInfo> {
	private final String MAIN_TABLE = DaoDbTable.EMP_MAT_TABLE;
	
	
	public EmpmatSelectSingle(Connection conn, EmpmatInfo recordInfo, String schemaName) {
		super(conn, recordInfo, schemaName);
	}
	
	
	
	@Override protected String getTableNameHook() {
		return MAIN_TABLE;
	}
	
	
	
	@Override protected DaoOperation getOperationHook() {
		return DaoOperation.SELECT;
	}
	
	
	
	@Override protected String buildWhereClauseHook(String tableName, EmpmatInfo recordInfo) {
		DaoWhereBuilderOption whereOption = new DaoWhereBuilderOption();
		whereOption.ignoreNull = DaoOptionValue.DONT_IGNORE_NULL;
		whereOption.ignoreRecordMode = DaoOptionValue.DONT_IGNORE_RECORD_MODE;		
		
		DaoStmtWhere whereClause = new EmpmatWhere(whereOption, tableName, recordInfo);
		return whereClause.getWhereClause();
	}
	
	
	
	@Override protected List<DaoJoin> getJoinsHook() {
		List<DaoJoin> joins = new ArrayList<>();
		
		DaoJoinBuilder joinEmp = new DaoJoinEmp(MAIN_TABLE);		
		joins.add(joinEmp.build());
		
		DaoJoinBuilder joinMat = new DaoJoinMat(MAIN_TABLE);		
		joins.add(joinMat.build());
		
		return joins;
	}
	
	
	
	@Override protected DaoResultParserV2<EmpmatInfo> getResultParserHook() {
		return new DaoResultParserV2<EmpmatInfo>() {
			@Override public List<EmpmatInfo> parseResult(EmpmatInfo recordInfo, ResultSet stmtResult, long lastId) throws SQLException {
				List<EmpmatInfo> finalResult = new ArrayList<>();
				
				if (stmtResult.next() == false)				
					return finalResult;
				
				do {
					EmpmatInfo dataInfo = new EmpmatInfo();
					
					dataInfo.codOwner = stmtResult.getLong(EmpmatDbTableColumn.COL_COD_OWNER);
					dataInfo.codEmployee = stmtResult.getLong(EmpmatDbTableColumn.COL_COD_EMPLOYEE);
					dataInfo.codMat = stmtResult.getLong(EmpmatDbTableColumn.COL_COD_MATERIAL);
					dataInfo.recordMode = stmtResult.getString(EmpmatDbTableColumn.COL_RECORD_MODE);	
					dataInfo.lastChanged = DaoFormatter.sqlToLocalDateTime(stmtResult, EmpmatDbTableColumn.COL_LAST_CHANGED);
					dataInfo.lastChangedBy = DaoFormatter.sqlToLong(stmtResult, EmpmatDbTableColumn.COL_LAST_CHANGED_BY);	
					
					finalResult.add(dataInfo);
				} while (stmtResult.next());
				
				return finalResult;
			}
		};
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		super.executeStmt();
	}
}
