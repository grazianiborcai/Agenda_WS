package br.com.gda.employee.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.employee.dao.EmpStmtExecSelect;
import br.com.gda.employee.info.EmpInfo;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.sql.SqlStmtExecOption;

public final class CheckerEmpExistOnDb extends ModelCheckerTemplate<EmpInfo> {
	private final boolean EMPLOYEE_EXIST = true;
	private final boolean NO_ENTRY_FOUND_ON_DB = false;
	
	
	public CheckerEmpExistOnDb(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpInfo recordInfo, Connection conn, String schemaName) {	
		try {
			EmpInfo enforcedInfo = enforceSelectByKey(recordInfo);
			
			List<EmpInfo> resultset = executeStmt(enforcedInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NO_ENTRY_FOUND_ON_DB;
			
			return EMPLOYEE_EXIST;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private EmpInfo enforceSelectByKey(EmpInfo recordInfo) {
		EmpInfo keyInfo = new EmpInfo();
		keyInfo.codOwner = recordInfo.codOwner;
		keyInfo.codEmployee = recordInfo.codEmployee;		
		return keyInfo;
	}
	
	
	
	private List<EmpInfo> executeStmt(EmpInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		EmpStmtExecSelect stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private EmpStmtExecSelect buildStmtExecutor(EmpInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<EmpInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<EmpInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new EmpStmtExecSelect(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.EMPLOYEE_ALREALDY_EXIST_ON_DB)
			return SystemMessage.EMPLOYEE_ALREALDY_EXIST_ON_DB;
		
		return SystemMessage.EMPLOYEE_DONT_EXIST_ON_DB;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == EMPLOYEE_EXIST)
			return SystemCode.EMPLOYEE_ALREALDY_EXIST_ON_DB;	
			
		return SystemCode.EMPLOYEE_DONT_EXIST_ON_DB;
	}
}
