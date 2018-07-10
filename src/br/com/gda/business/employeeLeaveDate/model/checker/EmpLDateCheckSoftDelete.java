package br.com.gda.business.employeeLeaveDate.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.dao.EmpLDateSelect;
import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpLDateCheckSoftDelete extends ModelCheckerTemplateSimple<EmpLDateInfo> {
	private final boolean RECORD_IS_DELETED = true;
	private final boolean NOT_FOUND_OR_NOT_DELETED = false;	
	
	
	public EmpLDateCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpLDateInfo recordInfo, Connection conn, String schemaName) {
		EmpLDateInfo clonedInfo = makeClone(recordInfo);
		clonedInfo.recordMode = RecordMode.RECORD_DELETED;
		
		try {
			List<EmpLDateInfo> resultset = executeStmt(clonedInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NOT_FOUND_OR_NOT_DELETED;
			
			return RECORD_IS_DELETED;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private EmpLDateInfo makeClone(EmpLDateInfo recordInfo) {
		try {
			return (EmpLDateInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
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
		return SystemMessage.EMP_LD_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.EMPLOYEE_LEAVE_DATE_FLAGGED_AS_DELETED;	
	}
}
