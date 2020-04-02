package br.com.mind5.payment.customerPartnerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;

public final class CusparchSelect implements DaoStmtExec_<CusparchInfo> {
	private DaoStmtExec_<CusparchInfo> helper;
	
	
	public CusparchSelect(List<DaoStmtExecOption<CusparchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CusparchSelectSingle.class, CusparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CusparchInfo> getResultset() {
		return helper.getResultset();
	}
}
