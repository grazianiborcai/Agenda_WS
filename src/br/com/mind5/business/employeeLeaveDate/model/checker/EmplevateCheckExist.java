package br.com.mind5.business.employeeLeaveDate.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.mind5.business.employeeLeaveDate.dao.EmplevateSelect;
import br.com.mind5.business.employeeLeaveDate.info.EmplevateInfo;
import br.com.mind5.common.SystemCode;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.model.checker.ModelCheckerOption;
import br.com.mind5.model.checker.ModelCheckerTemplateSimple_;

public final class EmplevateCheckExist extends ModelCheckerTemplateSimple_<EmplevateInfo> {
	private final boolean RECORD_EXIST = true;
	private final boolean NO_ENTRY_FOUND_ON_DB = false;
	
	
	public EmplevateCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmplevateInfo recordInfo, Connection conn, String schemaName) {	
		try {
			List<EmplevateInfo> resultset = executeStmt(recordInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NO_ENTRY_FOUND_ON_DB;
			
			return RECORD_EXIST;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<EmplevateInfo> executeStmt(EmplevateInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		DaoStmtExec<EmplevateInfo> stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private DaoStmtExec<EmplevateInfo> buildStmtExecutor(EmplevateInfo recordInfo, Connection conn, String schemaName) {
		DaoStmtExecOption<EmplevateInfo> stmtExecOption = new DaoStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<DaoStmtExecOption<EmplevateInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new EmplevateSelect(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.EMP_LDATE_ALREADY_EXIST)
			return SystemMessage.EMP_LDATE_ALREADY_EXIST;
		
		return SystemMessage.EMP_LDATE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == RECORD_EXIST)
			return SystemCode.EMP_LDATE_ALREADY_EXIST;
			
		return SystemCode.EMP_LDATE_NOT_FOUND;
	}
}
