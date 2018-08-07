package br.com.gda.business.storeEmployee.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.storeEmployee.info.StoreEmpInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class StoreEmpDelete implements DaoStmtExec<StoreEmpInfo> {
	private DaoStmtExec<StoreEmpInfo> helper;
	
	
	public StoreEmpDelete(List<DaoStmtExecOption<StoreEmpInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoreEmpDeleteSingle.class, StoreEmpInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StoreEmpInfo> getResultset() {
		return helper.getResultset();
	}
}
