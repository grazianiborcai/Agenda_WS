package br.com.gda.business.materialEmployee.model.chekcer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.gda.business.materialEmployee.dao.MatEmpSelect;
import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.common.SystemCode;
import br.com.gda.common.SystemMessage;
import br.com.gda.helper.RecordMode;
import br.com.gda.model.checker.ModelCheckerOption;
import br.com.gda.model.checker.ModelCheckerTemplate;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecOption;

public final class MatEmpCheckSoftDelete extends ModelCheckerTemplate<MatEmpInfo> {
	private final boolean RECORD_IS_DELETED = true;
	private final boolean NOT_FOUND_OR_NOT_DELETED = false;	
	
	
	public MatEmpCheckSoftDelete(ModelCheckerOption option) {
		super(option);
	}
	
	
	
	@Override protected boolean checkHook(MatEmpInfo recordInfo, Connection conn, String schemaName) {
		MatEmpInfo clonedInfo = makeClone(recordInfo);
		clonedInfo.recordMode = RecordMode.RECORD_DELETED;
		
		try {
			List<MatEmpInfo> resultset = executeStmt(clonedInfo, conn, schemaName);
			
			if (resultset == null || resultset.isEmpty())
				return NOT_FOUND_OR_NOT_DELETED;
			
			return RECORD_IS_DELETED;
			
		} catch (Exception e) {
			throw new IllegalStateException(SystemMessage.INTERNAL_ERROR);
		}
	}
	
	
	
	private MatEmpInfo makeClone(MatEmpInfo recordInfo) {
		try {
			return (MatEmpInfo) recordInfo.clone();
		} catch (CloneNotSupportedException e) {
			throw new IllegalStateException(e);
		}
	}
	
	
	
	private List<MatEmpInfo> executeStmt(MatEmpInfo recordInfo, Connection conn, String schemaName) throws SQLException {
		SqlStmtExec<MatEmpInfo> stmtExecutor = buildStmtExecutor(recordInfo, conn, schemaName);
		
		stmtExecutor.executeStmt();
		return stmtExecutor.getResultset();
	}
	
	
	
	private SqlStmtExec<MatEmpInfo> buildStmtExecutor(MatEmpInfo recordInfo, Connection conn, String schemaName) {
		SqlStmtExecOption<MatEmpInfo> stmtExecOption = new SqlStmtExecOption<>();
		stmtExecOption.conn = conn;
		stmtExecOption.recordInfo = recordInfo;
		stmtExecOption.schemaName = schemaName;
		
		List<SqlStmtExecOption<MatEmpInfo>> stmtExecOptions = new ArrayList<>();
		stmtExecOptions.add(stmtExecOption);
		
		return new MatEmpSelect(stmtExecOptions);
	}
	
	
	
	@Override protected String makeFailureExplanationHook(boolean checkerResult) {	
		return SystemMessage.STORE_MAT_EMP_FLAGGED_AS_DELETED;
	}
	
	
	
	@Override protected int makeFailureCodeHook(boolean checkerResult) {
		return SystemCode.STORE_MAT_EMP_FLAGGED_AS_DELETED;	
	}
}
