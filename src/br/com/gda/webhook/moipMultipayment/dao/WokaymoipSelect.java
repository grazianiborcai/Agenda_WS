package br.com.gda.webhook.moipMultipayment.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.webhook.moipMultipayment.info.WokaymoipInfo;

public final class WokaymoipSelect implements DaoStmtExec<WokaymoipInfo> {
	private DaoStmtExec<WokaymoipInfo> helper;
	
	
	public WokaymoipSelect(List<DaoStmtExecOption<WokaymoipInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, WokaymoipSelectSingle.class, WokaymoipInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<WokaymoipInfo> getResultset() {
		return helper.getResultset();
	}
}
