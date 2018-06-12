package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.TimezoneSelect;
import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class TimezoneCheckExist extends ModelCheckerTemplate<TimezoneInfo> {
	private final boolean EXIST_ON_DB = true;
	private final boolean NOT_FOUND_ON_DB = false;
	
	
	public TimezoneCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(TimezoneInfo recordInfo, Connection conn, String schemaName) {	
		try {		
			List<TimezoneInfo> resultset = executeStmt(recordInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NOT_FOUND_ON_DB;
			
			return EXIST_ON_DB;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<TimezoneInfo> executeStmt(TimezoneInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		SqlStmtExec<TimezoneInfo> stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private SqlStmtExec<TimezoneInfo> buildStmtExecutor(TimezoneInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<TimezoneInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<TimezoneInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new TimezoneSelect(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.TIMEZONE_ALREADY_EXIST)
			return SystemMessage.TIMEZONE_ALREADY_EXIST;
		
		return SystemMessage.TIMEZONE_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == EXIST_ON_DB)
			return SystemCode.TIMEZONE_ALREADY_EXIST;	
			
		return SystemCode.TIMEZONE_NOT_FOUND;
	}
}
