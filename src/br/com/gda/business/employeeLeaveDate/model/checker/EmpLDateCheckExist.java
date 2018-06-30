package br.com.gda.business.employeeLeaveDate.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.dao.EmpLDateSelect;
import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpLDateCheckExist extends ModelCheckerTemplate<EmpLDateInfo> {
	private final boolean RECORD_EXIST = true;
	private final boolean NO_ENTRY_FOUND_ON_DB = false;
	
	
	public EmpLDateCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpLDateInfo recordInfo, Connection conn, String schemaName) {	
		try {
			List<EmpLDateInfo> resultset = executeStmt(recordInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NO_ENTRY_FOUND_ON_DB;
			
			return RECORD_EXIST;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<EmpLDateInfo> executeStmt(EmpLDateInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		SqlStmtExec<EmpLDateInfo> stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private SqlStmtExec<EmpLDateInfo> buildStmtExecutor(EmpLDateInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<EmpLDateInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<EmpLDateInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new EmpLDateSelect(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.EMPLOYEE_LEAVE_DATE_ALREADY_EXIST)
			return SystemMessage.EMP_LD_ALREADY_EXIST;
		
		return SystemMessage.EMP_LD_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == RECORD_EXIST)
			return SystemCode.EMPLOYEE_LEAVE_DATE_ALREADY_EXIST;
			
		return SystemCode.EMPLOYEE_LEAVE_DATE_NOT_FOUND;
	}
}
