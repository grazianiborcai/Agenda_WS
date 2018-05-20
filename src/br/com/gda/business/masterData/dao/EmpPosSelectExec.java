package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.EmpPosInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public final class EmpPosSelectExec implements SqlStmtExec<EmpPosInfo> {
	private SqlStmtExec<EmpPosInfo> helper;
	
	
	public EmpPosSelectExec(List<SqlStmtExecOption<EmpPosInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, EmpPosSelect.class, EmpPosInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpPosInfo> getResultset() {
		return helper.getResultset();
	}
}
