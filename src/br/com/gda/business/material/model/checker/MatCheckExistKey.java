package br.com.gda.business.material.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.material.dao.MatSelect;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class MatCheckExistKey extends ModelCheckerTemplate<MatInfo> {
	private final boolean MATERIAL_EXIST = true;
	private final boolean NO_ENTRY_FOUND = false;
	
	
	public MatCheckExistKey(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatInfo recordInfo, Connection conn, String schemaName) {	
		try {
			MatInfo enforcedInfo = enforcePrimaryKey(recordInfo);
			List<MatInfo> resultset = executeStmt(enforcedInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NO_ENTRY_FOUND;
			
			return MATERIAL_EXIST;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private MatInfo enforcePrimaryKey(MatInfo recordInfo) {
		MatInfo enforcedInfo = new MatInfo();
		enforcedInfo.codOwner = recordInfo.codOwner;
		enforcedInfo.codMat = recordInfo.codMat;
		return enforcedInfo;
	}
	
	
	
	private List<MatInfo> executeStmt(MatInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		SqlStmtExec<MatInfo> stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private SqlStmtExec<MatInfo> buildStmtExecutor(MatInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<MatInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<MatInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new MatSelect(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.MATERIAL_ALREADY_EXIST)
			return SystemMessage.MATERIAL_ALREALDY_EXIST;
		
		return SystemMessage.MATERIAL_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == MATERIAL_EXIST)
			return SystemCode.MATERIAL_ALREADY_EXIST;	
			
		return SystemCode.MATERIAL_NOT_FOUND;
	}
}
