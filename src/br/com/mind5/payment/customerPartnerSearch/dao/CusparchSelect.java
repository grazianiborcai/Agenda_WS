package br.com.mind5.payment.customerPartnerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.payment.customerPartnerSearch.info.CusparchInfo;

public final class CusparchSelect implements DaoStmtExec<CusparchInfo> {
	private DaoStmtExec<CusparchInfo> helper;
	
	
	public CusparchSelect(List<DaoStmtExecOption<CusparchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CusparchSelectSingle.class, CusparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CusparchInfo> getResultset() {
		return helper.getResultset();
	}
}
