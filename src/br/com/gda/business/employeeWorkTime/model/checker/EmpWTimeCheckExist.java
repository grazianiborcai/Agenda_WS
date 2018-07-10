package br.com.gda.business.employeeWorkTime.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.dao.EmpWTimeSelect;
import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public class EmpWTimeCheckExist extends ModelCheckerTemplateSimple<EmpWTimeInfo> {
	private final boolean RECORD_EXIST = true;
	private final boolean NO_ENTRY_FOUND = false;
	
	
	public EmpWTimeCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpWTimeInfo recordInfo, Connection conn, String schemaName) {	
		try {
			List<EmpWTimeInfo> resultset = executeStmt(recordInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NO_ENTRY_FOUND;
			
			return RECORD_EXIST;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<EmpWTimeInfo> executeStmt(EmpWTimeInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		SqlStmtExec<EmpWTimeInfo> stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private SqlStmtExec<EmpWTimeInfo> buildStmtExecutor(EmpWTimeInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<EmpWTimeInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<EmpWTimeInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new EmpWTimeSelect(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.EMP_WTIME_ALREADY_EXIST)
			return SystemMessage.EMP_WTIME_ALREALDY_EXIST;
		
		return SystemMessage.EMP_WTIME_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == RECORD_EXIST)
			return SystemCode.EMP_WTIME_ALREADY_EXIST;	
			
		return SystemCode.EMP_WTIME_NOT_FOUND;
	}
}
