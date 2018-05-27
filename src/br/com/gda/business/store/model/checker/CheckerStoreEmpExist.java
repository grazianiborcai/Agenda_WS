package br.com.gda.business.store.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreEmpStmtExecSelect;
import br.com.gda.business.store.info.StoreEmpInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.sql.SqlStmtExecOption;

public final class CheckerStoreEmpExist extends ModelCheckerTemplate<StoreEmpInfo> {
	private final boolean STORE_EMP_EXIST = true;
	private final boolean NO_ENTRY_FOUND_ON_DB = false;
	
	
	public CheckerStoreEmpExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoreEmpInfo recordInfo, Connection conn, String schemaName) {	
		try {
			List<StoreEmpInfo> resultset = executeStmt(recordInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NO_ENTRY_FOUND_ON_DB;
			
			return STORE_EMP_EXIST;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<StoreEmpInfo> executeStmt(StoreEmpInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		StoreEmpStmtExecSelect stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private StoreEmpStmtExecSelect buildStmtExecutor(StoreEmpInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<StoreEmpInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<StoreEmpInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new StoreEmpStmtExecSelect(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.STORE_EMP_ALREALDY_EXIST)
			return SystemMessage.STORE_EMP_ALREALDY_EXIST;
		
		return SystemMessage.STORE_EMP_DATA_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == STORE_EMP_EXIST)
			return SystemCode.STORE_EMP_ALREALDY_EXIST;	
			
		return SystemCode.STORE_EMP_NOT_FOUND;
	}
}
