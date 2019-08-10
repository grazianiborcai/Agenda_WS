package br.com.gda.webhook.moipRefund.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.webhook.moipRefund.info.WokefumoipInfo;

public final class WokefumoipSelect implements DaoStmtExec<WokefumoipInfo> {
	private DaoStmtExec<WokefumoipInfo> helper;
	
	
	public WokefumoipSelect(List<DaoStmtExecOption<WokefumoipInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, WokefumoipSelectSingle.class, WokefumoipInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<WokefumoipInfo> getResultset() {
		return helper.getResultset();
	}
}
