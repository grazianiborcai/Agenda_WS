package br.com.gda.business.materialStore.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialStore.dao.MatStoreSelect;
import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;

public final class MatStoreCheckExist extends ModelCheckerTemplateSimple<MatStoreInfo> {
	private final boolean RECORD_EXIST = true;
	private final boolean NO_ENTRY_FOUND_ON_DB = false;
	
	
	public MatStoreCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatStoreInfo recordInfo, Connection conn, String schemaName) {	
		try {
			List<MatStoreInfo> resultset = executeStmt(recordInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NO_ENTRY_FOUND_ON_DB;
			
			return RECORD_EXIST;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<MatStoreInfo> executeStmt(MatStoreInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		DaoStmtExec<MatStoreInfo> stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private DaoStmtExec<MatStoreInfo> buildStmtExecutor(MatStoreInfo recordInfo, Connection conn, String schemaName) {
		DaoStmtExecOption<MatStoreInfo> stmtExecOption = new DaoStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<DaoStmtExecOption<MatStoreInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new MatStoreSelect(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.STORE_MAT_ALREADY_EXIST)
			return SystemMessage.STORE_MAT_ALREADY_EXIST;
		
		return SystemMessage.STORE_MAT_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == RECORD_EXIST)
			return SystemCode.STORE_MAT_ALREADY_EXIST;	
			
		return SystemCode.STORE_MAT_NOT_FOUND;
	}
}
