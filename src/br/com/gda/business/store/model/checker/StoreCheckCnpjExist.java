package br.com.gda.business.store.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.store.dao.StoreSelect;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.sql.SqlStmtExecOption;

public final class StoreCheckCnpjExist extends ModelCheckerTemplate<StoreInfo> {
	private final boolean CNPJ_ALREADY_EXIST_ON_DB = true;
	private final boolean CNPJ_NOT_FOUND_ON_DB = false;
	
	
	public StoreCheckCnpjExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoreInfo recordInfo, Connection conn, String schemaName) {	
		try {
			StoreInfo enforcedInfo = enforceSlectByCnpj(recordInfo);			
			List<StoreInfo> resultset = executeStmt(enforcedInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return CNPJ_NOT_FOUND_ON_DB;
			
			return CNPJ_ALREADY_EXIST_ON_DB;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private StoreInfo enforceSlectByCnpj(StoreInfo recordInfo) {
		StoreInfo enforcedInfo = new StoreInfo();
		enforcedInfo.codOwner = recordInfo.codOwner;
		enforcedInfo.cnpj = recordInfo.cnpj;
		return enforcedInfo;
	}
	
	
	
	private List<StoreInfo> executeStmt(StoreInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		StoreSelect stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private StoreSelect buildStmtExecutor(StoreInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<StoreInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<StoreInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new StoreSelect(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.STORE_CNPJ_ALREADY_EXIST)
			return SystemMessage.STORE_CNPJ_ALREADY_EXIST;
		
		return SystemMessage.STORE_CNPJ_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == CNPJ_ALREADY_EXIST_ON_DB)
			return SystemCode.STORE_CNPJ_ALREADY_EXIST;	
			
		return SystemCode.STORE_CNPJ_NOT_FOUND;
	}
}
