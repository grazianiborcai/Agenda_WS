package br.com.mind5.webhook.moipRefund.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

public final class WokefumoipSelect implements DaoStmtExec_<WokefumoipInfo> {
	private DaoStmtExec_<WokefumoipInfo> helper;
	
	
	public WokefumoipSelect(List<DaoStmtExecOption<WokefumoipInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, WokefumoipSelectSingle.class, WokefumoipInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<WokefumoipInfo> getResultset() {
		return helper.getResultset();
	}
}
