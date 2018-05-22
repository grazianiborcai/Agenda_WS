package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.MatTypeSelectExec;
import br.com.gda.business.masterData.info.MatTypeInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class MatTypeCheckExist extends ModelCheckerTemplate<MatTypeInfo> {
	private final boolean EXIST_ON_DB = true;
	private final boolean NOT_FOUND_ON_DB = false;
	
	
	public MatTypeCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatTypeInfo recordInfo, Connection conn, String schemaName) {	
		try {		
			List<MatTypeInfo> resultset = executeStmt(recordInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NOT_FOUND_ON_DB;
			
			return EXIST_ON_DB;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<MatTypeInfo> executeStmt(MatTypeInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		SqlStmtExec<MatTypeInfo> stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private SqlStmtExec<MatTypeInfo> buildStmtExecutor(MatTypeInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<MatTypeInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<MatTypeInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new MatTypeSelectExec(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.MAT_TYPE_ALREADY_EXIST)
			return SystemMessage.MAT_TYPE_ALREADY_EXIST;
		
		return SystemMessage.MAT_TYPE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == EXIST_ON_DB)
			return SystemCode.MAT_TYPE_ALREADY_EXIST;	
			
		return SystemCode.MAT_TYPE_NOT_FOUND;
	}
}
