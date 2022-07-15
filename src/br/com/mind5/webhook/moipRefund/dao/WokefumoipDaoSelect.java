package br.com.mind5.webhook.moipRefund.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

public final class WokefumoipDaoSelect implements DaoStmtExec<WokefumoipInfo> {
	private DaoStmtExec<WokefumoipInfo> helper;
	
	
	public WokefumoipDaoSelect(List<DaoStmtExecOption<WokefumoipInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, WokefumoipDaoSelectSingle.class, WokefumoipInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<WokefumoipInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
