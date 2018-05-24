package br.com.gda.business.employee.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.dao.EmpStmtExecSelect;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpCheckExist extends ModelCheckerTemplate<EmpInfo> {
	private final boolean EMPLOYEE_EXIST = true;
	private final boolean NO_ENTRY_FOUND_ON_DB = false;
	
	
	public EmpCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpInfo recordInfo, Connection conn, String schemaName) {	
		try {
			EmpInfo enforcedInfo = enforceSelectByConstraint(recordInfo);
			
			List<EmpInfo> resultset = executeStmt(enforcedInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NO_ENTRY_FOUND_ON_DB;
			
			return EMPLOYEE_EXIST;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private EmpInfo enforceSelectByConstraint(EmpInfo recordInfo) {
		EmpInfo keyInfo;
		try {
			keyInfo = (EmpInfo) recordInfo.clone();
			keyInfo.recordMode = RecordMode.RECORD_OK;
			return keyInfo;
		
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
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
		if (makeFailureCodeHook(checkerResult) == SystemCode.EMPLOYEE_ALREALDY_EXIST)
			return SystemMessage.EMPLOYEE_ALREALDY_EXIST;
		
		return SystemMessage.EMPLOYEE_DATA_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == EMPLOYEE_EXIST)
			return SystemCode.EMPLOYEE_ALREALDY_EXIST;	
			
		return SystemCode.EMPLOYEE_NOT_FOUND;
	}
}
