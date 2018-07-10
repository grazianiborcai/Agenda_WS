package br.com.gda.business.storeWorkTime.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeWorkTime.dao.StoreWTimeSelect;
import br.com.gda.business.storeWorkTime.info.StoreWTimeInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class StoreWTimeCheckExist extends ModelCheckerTemplateSimple<StoreWTimeInfo> {
	private final boolean RECORD_EXIST = true;
	private final boolean NO_ENTRY_FOUND_ON_DB = false;
	
	
	public StoreWTimeCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoreWTimeInfo recordInfo, Connection conn, String schemaName) {	
		try {
			List<StoreWTimeInfo> resultset = executeStmt(recordInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NO_ENTRY_FOUND_ON_DB;
			
			return RECORD_EXIST;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<StoreWTimeInfo> executeStmt(StoreWTimeInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		SqlStmtExec<StoreWTimeInfo> stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private SqlStmtExec<StoreWTimeInfo> buildStmtExecutor(StoreWTimeInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<StoreWTimeInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<StoreWTimeInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new StoreWTimeSelect(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.STORE_WTIME_ALREADY_EXIST)
			return SystemMessage.STORE_WTIME_ALREADY_EXIST;
		
		return SystemMessage.STORE_WTIME_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == RECORD_EXIST)
			return SystemCode.STORE_WTIME_ALREADY_EXIST;	
			
		return SystemCode.STORE_WTIME_NOT_FOUND;
	}
}
