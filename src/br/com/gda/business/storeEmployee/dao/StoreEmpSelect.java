package br.com.gda.business.storeEmployee.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.sql.SqlStmtExec;
import br.com.gda.sql.SqlStmtExecHelper;
import br.com.gda.sql.SqlStmtExecOption;

public class StoreEmpSelect implements SqlStmtExec<StoreEmpInfo> {
	private SqlStmtExec<StoreEmpInfo> helper;
	
	
	public StoreEmpSelect(List<SqlStmtExecOption<StoreEmpInfo>> options) {
		helper = new SqlStmtExecHelper<>(options, StoreEmpSelectSingle.class, StoreEmpInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StoreEmpInfo> getResultset() {
		return helper.getResultset();
	}
}
