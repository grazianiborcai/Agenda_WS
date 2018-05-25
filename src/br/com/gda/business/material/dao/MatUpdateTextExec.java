package br.com.gda.business.material.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class MatUpdateTextExec implements SqlStmtExec<MatInfo> {
	private SqlStmtExec<MatInfo> helper;
	
	
	public MatUpdateTextExec(List<SqlStmtExecOption<MatInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, MatUpdateText.class, MatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<MatInfo> getResultset() {
		return helper.getResultset();
	}
}
