package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.EmpPosSelectExec;
import br.com.gda.business.masterData.info.EmpPosInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.sql.SqlStmtExecOption;

public final class CheckerEmpPosExistOnDb extends ModelCheckerTemplate<EmpPosInfo> {
	private final boolean POSITION_EXIST_ON_DB = true;
	private final boolean POSITION_NOT_FOUND_ON_DB = false;
	
	
	public CheckerEmpPosExistOnDb(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpPosInfo recordInfo, Connection conn, String schemaName) {	
		try {		
			List<EmpPosInfo> resultset = executeStmt(recordInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return POSITION_NOT_FOUND_ON_DB;
			
			return POSITION_EXIST_ON_DB;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<EmpPosInfo> executeStmt(EmpPosInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		EmpPosSelectExec stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private EmpPosSelectExec buildStmtExecutor(EmpPosInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<EmpPosInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<EmpPosInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new EmpPosSelectExec(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.POSITION_ALREADY_EXIST)
			return SystemMessage.POSITION_ALREADY_EXIST;
		
		return SystemMessage.POSITION_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == POSITION_EXIST_ON_DB)
			return SystemCode.POSITION_ALREADY_EXIST;	
			
		return SystemCode.POSITION_NOT_FOUND;
	}
}
