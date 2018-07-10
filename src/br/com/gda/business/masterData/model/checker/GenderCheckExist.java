package br.com.gda.business.masterData.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.masterData.dao.GenderSelect;
import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class GenderCheckExist extends ModelCheckerTemplateSimple<GenderInfo> {
	private final boolean EXIST_ON_DB = true;
	private final boolean NOT_FOUND_ON_DB = false;
	
	
	public GenderCheckExist(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(GenderInfo recordInfo, Connection conn, String schemaName) {	
		try {		
			List<GenderInfo> resultset = executeStmt(recordInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NOT_FOUND_ON_DB;
			
			return EXIST_ON_DB;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private List<GenderInfo> executeStmt(GenderInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		SqlStmtExec<GenderInfo> stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private SqlStmtExec<GenderInfo> buildStmtExecutor(GenderInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<GenderInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<GenderInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new GenderSelect(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {		
		if (makeFailureCodeHook(checkerResult) == SystemCode.GENDER_ALREADY_EXIST)
			return SystemMessage.GENDER_ALREADY_EXIST;
		
		return SystemMessage.GENDER_NOT_FOUND;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		if (checkerResult == EXIST_ON_DB)
			return SystemCode.GENDER_ALREADY_EXIST;	
			
		return SystemCode.GENDER_NOT_FOUND;
	}
}
