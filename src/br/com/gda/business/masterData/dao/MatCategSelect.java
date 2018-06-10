package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.MatCategInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class MatCategSelect implements SqlStmtExec<MatCategInfo> {
	private SqlStmtExec<MatCategInfo> helper;
	
	
	public MatCategSelect(List<SqlStmtExecOption<MatCategInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, MatCategSelectSingle.class, MatCategInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatCategInfo> getResultset() {
		return helper.getResultset();
	}
}
