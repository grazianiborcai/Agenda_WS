package br.com.gda.business.customer.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class CusSelect implements DaoStmtExec<CusInfo> {
	private DaoStmtExec<CusInfo> helper;
	
	
	public CusSelect(List<DaoStmtExecOption<CusInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CusSelectSingle.class, CusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CusInfo> getResultset() {
		return helper.getResultset();
	}
}
