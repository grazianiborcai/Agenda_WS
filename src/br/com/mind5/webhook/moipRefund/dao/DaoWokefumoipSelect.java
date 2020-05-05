package br.com.mind5.webhook.moipRefund.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.webhook.moipRefund.info.WokefumoipInfo;

public final class DaoWokefumoipSelect implements DaoStmtExecV2<WokefumoipInfo> {
	private DaoStmtExecV2<WokefumoipInfo> helper;
	
	
	public DaoWokefumoipSelect(List<DaoStmtExecOption<WokefumoipInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoWokefumoipSelectSingle.class, WokefumoipInfo.class);
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
