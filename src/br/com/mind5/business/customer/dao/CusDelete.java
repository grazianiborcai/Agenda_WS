package br.com.mind5.business.customer.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class CusDelete implements DaoStmtExec<CusInfo> {
	private DaoStmtExec<CusInfo> helper;
	
	
	public CusDelete(List<DaoStmtExecOption<CusInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CusDeleteSingle.class, CusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CusInfo> getResultset() {
		return helper.getResultset();
	}
}
