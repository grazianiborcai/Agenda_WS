package br.com.mind5.business.customer.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class CusUpdate implements DaoStmtExec_<CusInfo> {
	private DaoStmtExec_<CusInfo> helper;
	
	
	public CusUpdate(List<DaoStmtExecOption<CusInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CusUpdateSingle.class, CusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CusInfo> getResultset() {
		return helper.getResultset();
	}
}
