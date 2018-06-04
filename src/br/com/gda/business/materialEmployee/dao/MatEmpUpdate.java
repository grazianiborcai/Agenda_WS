package br.com.gda.business.materialEmployee.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class MatEmpUpdate implements SqlStmtExec<MatEmpInfo> {
	private SqlStmtExec<MatEmpInfo> helper;
	
	
	public MatEmpUpdate(List<SqlStmtExecOption<MatEmpInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, MatEmpUpdateSingle.class, MatEmpInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatEmpInfo> getResultset() {
		return helper.getResultset();
	}
}
