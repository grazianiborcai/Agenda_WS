package br.com.gda.business.employee.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.dao.EmpSelectExec;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpCheckUniqueness extends ModelCheckerTemplate<EmpInfo> {
	private final boolean SINGLE_EMPLOYEE_FOUND = true;
	private final boolean MULTIPLE_ENTRIES_FOUND_ON_DB = false;
	
	
	public EmpCheckUniqueness(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpInfo recordInfo, Connection conn, String schemaName) {	
		try {
			List<EmpInfo> resultset = executeStmt(recordInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				throw new IllegalStateException(SystemMessage.EMPLOYEE_DATA_NOT_FOUND);
				
			if (resultset.size() > 1)
				return MULTIPLE_ENTRIES_FOUND_ON_DB;
			
			return SINGLE_EMPLOYEE_FOUND;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<EmpInfo> executeStmt(EmpInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		EmpSelectExec stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private EmpSelectExec buildStmtExecutor(EmpInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<EmpInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<EmpInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new EmpSelectExec(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.EMPLOYEE_MULTIPLE_ENTRIES_FOUND)
			return SystemMessage.EMPLOYEE_MULTIPLE_ENTRIES_FOUND;
		
		return SystemMessage.EMPLOYEE_SINGLE_ENTRY_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == SINGLE_EMPLOYEE_FOUND)
			return SystemCode.EMPLOYEE_MULTIPLE_ENTRIES_FOUND;	
			
		return SystemCode.EMPLOYEE_NOT_FOUND;
	}
}
