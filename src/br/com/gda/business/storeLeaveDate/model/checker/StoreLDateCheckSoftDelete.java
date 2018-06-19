package br.com.gda.business.storeLeaveDate.model.checker;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.storeLeaveDate.dao.StoreLDateSelect;
import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class StoreLDateCheckSoftDelete extends ModelCheckerTemplate<StoreLDateInfo> {
	private final boolean RECORD_IS_DELETED = true;
	private final boolean NOT_FOUND_OR_NOT_DELETED = false;	
	
	
	public StoreLDateCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(StoreLDateInfo recordInfo, Connection conn, String schemaName) {
		StoreLDateInfo clonedInfo = makeClone(recordInfo);
		clonedInfo.recordMode = RecordMode.RECORD_DELETED;
		
		try {
			List<StoreLDateInfo> resultset = executeStmt(clonedInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NOT_FOUND_OR_NOT_DELETED;
			
			return RECORD_IS_DELETED;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private StoreLDateInfo makeClone(StoreLDateInfo recordInfo) {
		try {
			return (StoreLDateInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
	
	
	
	private List<StoreLDateInfo> executeStmt(StoreLDateInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		SqlStmtExec<StoreLDateInfo> stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private SqlStmtExec<StoreLDateInfo> buildStmtExecutor(StoreLDateInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<StoreLDateInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<StoreLDateInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new StoreLDateSelect(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {	
		return SystemMessage.STORE_LDATE_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.STORE_LDATE_FLAGGED_AS_DELETED;	
	}
}
