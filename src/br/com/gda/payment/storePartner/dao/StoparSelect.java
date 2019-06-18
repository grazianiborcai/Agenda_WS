package br.com.gda.payment.storePartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payment.storePartner.info.StoparInfo;

public final class StoparSelect implements DaoStmtExec<StoparInfo> {
	private DaoStmtExec<StoparInfo> helper;
	
	
	public StoparSelect(List<DaoStmtExecOption<StoparInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoparSelectSingle.class, StoparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoparInfo> getResultset() {
		return helper.getResultset();
	}
}
