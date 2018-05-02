package br.com.gda.businessModel.employee.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.businessModel.employee.dao.EmpWtimeStmtExecSelect;
import br.com.gda.businessModel.employee.info.EmpWTimeInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.sql.SqlStmtExecOption;

public final class CheckerEmpWtimeSoftDelete extends ModelCheckerTemplate<EmpWTimeInfo> {
	private final boolean EMPLOYEE_WORKING_IS_DELETED = true;
	private final boolean NOT_FOUND_OR_NOT_DELETED = false;	
	
	
	public CheckerEmpWtimeSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpWTimeInfo recordInfo, Connection conn, String schemaName) {
		EmpWTimeInfo clonedInfo = makeClone(recordInfo);
		clonedInfo.recordMode = RecordMode.RECORD_DELETED;
		
		try {
			List<EmpWTimeInfo> resultset = executeStmt(clonedInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NOT_FOUND_OR_NOT_DELETED;
			
			return EMPLOYEE_WORKING_IS_DELETED;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private EmpWTimeInfo makeClone(EmpWTimeInfo recordInfo) {
		try {
			return (EmpWTimeInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
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
		return SystemMessage.EMPLOYEE_WORKING_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.EMPLOYEE_WORKING_FLAGGED_AS_DELETED;	
	}
}
