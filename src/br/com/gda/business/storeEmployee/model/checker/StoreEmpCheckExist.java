package br.com.gda.business.storeEmployee.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeEmployee.dao.StoreEmpSelect;
import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class StoreEmpCheckExist extends ModelCheckerTemplateSimple<StoreEmpInfo> {
	private final boolean RECORD_EXIST = true;
	private final boolean NO_ENTRY_FOUND_ON_DB = false;
	
	
	public StoreEmpCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoreEmpInfo recordInfo, Connection conn, String schemaName) {	
		try {
			List<StoreEmpInfo> resultset = executeStmt(recordInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NO_ENTRY_FOUND_ON_DB;
			
			return RECORD_EXIST;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<StoreEmpInfo> executeStmt(StoreEmpInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		SqlStmtExec<StoreEmpInfo> stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private SqlStmtExec<StoreEmpInfo> buildStmtExecutor(StoreEmpInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<StoreEmpInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<StoreEmpInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new StoreEmpSelect(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.STORE_EMP_ALREADY_EXIST)
			return SystemMessage.STORE_EMP_ALREALDY_EXIST;
		
		return SystemMessage.STORE_EMP_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == RECORD_EXIST)
			return SystemCode.STORE_EMP_ALREADY_EXIST;	
			
		return SystemCode.STORE_EMP_NOT_FOUND;
	}
}
