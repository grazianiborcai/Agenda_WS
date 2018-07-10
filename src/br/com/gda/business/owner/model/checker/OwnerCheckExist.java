package br.com.gda.business.owner.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.owner.dao.OwnerSelectExec;
import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class OwnerCheckExist extends ModelCheckerTemplateSimple<OwnerInfo> {
	private final boolean OWNER_EXIST = true;
	private final boolean NO_ENTRY_FOUND = false;
	
	
	public OwnerCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(OwnerInfo recordInfo, Connection conn, String schemaName) {	
		try {
			OwnerInfo enforcedInfo = enforcePrimaryKey(recordInfo);
			List<OwnerInfo> resultset = executeStmt(enforcedInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NO_ENTRY_FOUND;
			
			return OWNER_EXIST;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private OwnerInfo enforcePrimaryKey(OwnerInfo recordInfo) {
		OwnerInfo enforcedInfo = new OwnerInfo();
		enforcedInfo.codOwner = recordInfo.codOwner;
		return enforcedInfo;
	}
	
	
	
	private List<OwnerInfo> executeStmt(OwnerInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		SqlStmtExec<OwnerInfo> stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private SqlStmtExec<OwnerInfo> buildStmtExecutor(OwnerInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<OwnerInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<OwnerInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new OwnerSelectExec(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.OWNER_ALREADY_EXIST)
			return SystemMessage.OWNER_ALREALDY_EXIST;
		
		return SystemMessage.OWNER_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == OWNER_EXIST)
			return SystemCode.OWNER_ALREADY_EXIST;	
			
		return SystemCode.OWNER_NOT_FOUND;
	}
}
