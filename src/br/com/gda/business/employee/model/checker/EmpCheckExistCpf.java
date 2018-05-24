package br.com.gda.business.employee.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employee.dao.EmpStmtExecSelect;
import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpCheckExistCpf extends ModelCheckerTemplate<EmpInfo> {
	private final boolean CPF_ALREADY_EXIST_ON_DB = true;
	private final boolean CPF_NOT_FOUND_ON_DB = false;
	
	
	public EmpCheckExistCpf(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpInfo recordInfo, Connection conn, String schemaName) {	
		try {
			EmpInfo enforcedInfo = enforceSlectByCpf(recordInfo);			
			List<EmpInfo> resultset = executeStmt(enforcedInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return CPF_NOT_FOUND_ON_DB;
			
			return CPF_ALREADY_EXIST_ON_DB;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private EmpInfo enforceSlectByCpf(EmpInfo recordInfo) {
		EmpInfo enforcedInfo = new EmpInfo();
		enforcedInfo.codOwner = recordInfo.codOwner;
		enforcedInfo.cpf = recordInfo.cpf;
		return enforcedInfo;
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
		if (makeFailureCodeHook(checkerResult) == SystemCode.EMPLOYEE_CPF_ALREADY_EXIST)
			return SystemMessage.EMPLOYEE_CPF_ALREADY_EXIST;
		
		return SystemMessage.EMPLOYEE_CPF_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == CPF_ALREADY_EXIST_ON_DB)
			return SystemCode.EMPLOYEE_CPF_ALREADY_EXIST;	
			
		return SystemCode.EMPLOYEE_CPF_NOT_FOUND;
	}
}
