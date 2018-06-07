package br.com.gda.business.material.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class MatUpdateText implements SqlStmtExec<MatInfo> {
	private SqlStmtExec<MatInfo> helper;
	
	
	public MatUpdateText(List<SqlStmtExecOption<MatInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, MatUpdateTextSingle.class, MatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<MatInfo> getResultset() {
		return helper.getResultset();
	}
}
