package br.com.gda.business.store.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreSelectExec;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.sql.SqlStmtExecOption;

public final class StoreCheckKeyCnpj extends ModelCheckerTemplate<StoreInfo> {
	private final boolean STORE_EXIST = true;
	private final boolean NO_ENTRY_FOUND_ON_DB = false;
	
	
	public StoreCheckKeyCnpj(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoreInfo recordInfo, Connection conn, String schemaName) {	
		try {
			StoreInfo enforcedInfo = enforceSelectByConstraint(recordInfo);
			
			List<StoreInfo> resultset = executeStmt(enforcedInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NO_ENTRY_FOUND_ON_DB;
			
			return STORE_EXIST;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private StoreInfo enforceSelectByConstraint(StoreInfo recordInfo) {
		StoreInfo keyInfo;
		try {
			keyInfo = (StoreInfo) recordInfo.clone();
			keyInfo.recordMode = RecordMode.RECORD_OK;
			return keyInfo;
		
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
	
	
	
	private List<StoreInfo> executeStmt(StoreInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		StoreSelectExec stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private StoreSelectExec buildStmtExecutor(StoreInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<StoreInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<StoreInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new StoreSelectExec(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.STORE_ALREALDY_EXIST)
			return SystemMessage.STORE_ALREALDY_EXIST;
		
		return SystemMessage.STORE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == STORE_EXIST)
			return SystemCode.STORE_ALREALDY_EXIST;	
			
		return SystemCode.STORE_NOT_FOUND;
	}
}
