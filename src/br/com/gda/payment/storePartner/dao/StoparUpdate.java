package br.com.gda.payment.storePartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payment.storePartner.info.StoparInfo;

public final class StoparUpdate implements DaoStmtExec<StoparInfo> {
	private DaoStmtExec<StoparInfo> helper;
	
	
	public StoparUpdate(List<DaoStmtExecOption<StoparInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoparUpdateSingle.class, StoparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoparInfo> getResultset() {
		return helper.getResultset();
	}
}
