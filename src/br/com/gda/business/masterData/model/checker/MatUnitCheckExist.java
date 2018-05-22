package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.MatUnitSelectExec;
import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class MatUnitCheckExist extends ModelCheckerTemplate<MatUnitInfo> {
	private final boolean EXIST_ON_DB = true;
	private final boolean NOT_FOUND_ON_DB = false;
	
	
	public MatUnitCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatUnitInfo recordInfo, Connection conn, String schemaName) {	
		try {		
			List<MatUnitInfo> resultset = executeStmt(recordInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NOT_FOUND_ON_DB;
			
			return EXIST_ON_DB;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<MatUnitInfo> executeStmt(MatUnitInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		SqlStmtExec<MatUnitInfo> stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private SqlStmtExec<MatUnitInfo> buildStmtExecutor(MatUnitInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<MatUnitInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<MatUnitInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new MatUnitSelectExec(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.UNIT_ALREADY_EXIST)
			return SystemMessage.UNIT_ALREADY_EXIST;
		
		return SystemMessage.UNIT_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == EXIST_ON_DB)
			return SystemCode.UNIT_ALREADY_EXIST;	
			
		return SystemCode.UNIT_NOT_FOUND;
	}
}
