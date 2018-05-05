package br.com.gda.business.employee.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.dao.EmpWtimeStmtExecSelect;
import br.com.gda.business.employee.info.EmpWTimeInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.sql.SqlStmtExecOption;

public class CheckerEmpWtimeExistOnDb extends ModelCheckerTemplate<EmpWTimeInfo> {
	private final boolean EMPLOYEE_WORKING_TIME_EXIST = true;
	private final boolean NO_ENTRY_FOUND_ON_DB = false;
	
	
	public CheckerEmpWtimeExistOnDb(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpWTimeInfo recordInfo, Connection conn, String schemaName) {	
		try {
			List<EmpWTimeInfo> resultset = executeStmt(recordInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NO_ENTRY_FOUND_ON_DB;
			
			return EMPLOYEE_WORKING_TIME_EXIST;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<EmpWTimeInfo> executeStmt(EmpWTimeInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		EmpWtimeStmtExecSelect stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private EmpWtimeStmtExecSelect buildStmtExecutor(EmpWTimeInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<EmpWTimeInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<EmpWTimeInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new EmpWtimeStmtExecSelect(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.EMPLOYEE_WORKING_TIME_ALREALDY_EXIST_ON_DB)
			return SystemMessage.EMPLOYEE_WORKING_TIME_ALREALDY_EXIST_ON_DB;
		
		return SystemMessage.EMPLOYEE_WORKING_TIME_DONT_EXIST_ON_DB;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == EMPLOYEE_WORKING_TIME_EXIST)
			return SystemCode.EMPLOYEE_WORKING_TIME_ALREALDY_EXIST_ON_DB;	
			
		return SystemCode.EMPLOYEE_WORKING_TIME_DONT_EXIST_ON_DB;
	}
}
