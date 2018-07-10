package br.com.gda.business.employeeWorkTime.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.employeeWorkTime.dao.EmpWTimeSelect;
import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplateSimple;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpWTimeCheckSoftDelete extends ModelCheckerTemplateSimple<EmpWTimeInfo> {
	private final boolean RECORD_IS_DELETED = true;
	private final boolean NOT_FOUND_OR_NOT_DELETED = false;	
	
	
	public EmpWTimeCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(EmpWTimeInfo recordInfo, Connection conn, String schemaName) {
		EmpWTimeInfo clonedInfo = makeClone(recordInfo);
		clonedInfo.recordMode = RecordMode.RECORD_DELETED;
		
		try {
			List<EmpWTimeInfo> resultset = executeStmt(clonedInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NOT_FOUND_OR_NOT_DELETED;
			
			return RECORD_IS_DELETED;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private EmpWTimeInfo makeClone(EmpWTimeInfo recordInfo) {
		try {
			return (EmpWTimeInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
	
	
	
	private List<EmpWTimeInfo> executeStmt(EmpWTimeInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		EmpWTimeSelect stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private EmpWTimeSelect buildStmtExecutor(EmpWTimeInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<EmpWTimeInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<EmpWTimeInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new EmpWTimeSelect(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {	
		return SystemMessage.EMP_WTIME_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.EMP_WTIME_FLAGGED_AS_DELETED;	
	}
}
