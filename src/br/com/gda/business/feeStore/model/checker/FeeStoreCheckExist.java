package br.com.gda.business.feeStore.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.feeStore.dao.FeeStoreSelect;
import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class FeeStoreCheckExist extends ModelCheckerTemplateSimple<FeeStoreInfo> {
	private final boolean RECORD_EXIST = true;
	private final boolean NO_ENTRY_FOUND_ON_DB = false;
	
	
	public FeeStoreCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(FeeStoreInfo recordInfo, Connection conn, String schemaName) {	
		try {
			List<FeeStoreInfo> resultset = executeStmt(recordInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NO_ENTRY_FOUND_ON_DB;
			
			return RECORD_EXIST;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<FeeStoreInfo> executeStmt(FeeStoreInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		DaoStmtExec<FeeStoreInfo> stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private DaoStmtExec<FeeStoreInfo> buildStmtExecutor(FeeStoreInfo recordInfo, Connection conn, String schemaName) {
		DaoStmtExecOption<FeeStoreInfo> stmtExecOption = new DaoStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<DaoStmtExecOption<FeeStoreInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new FeeStoreSelect(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.STORE_FEE_ALREADY_EXIST)
			return SystemMessage.STORE_FEE_ALREADY_EXIST;
		
		return SystemMessage.STORE_FEE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == RECORD_EXIST)
			return SystemCode.STORE_FEE_ALREADY_EXIST;	
			
		return SystemCode.STORE_FEE_NOT_FOUND;
	}
}
