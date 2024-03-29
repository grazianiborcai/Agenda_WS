package br.com.mind5.webhook.moipMultipayment.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

public final class WokaymoipDaoSelect implements DaoStmtExec<WokaymoipInfo> {
	private DaoStmtExec<WokaymoipInfo> helper;
	
	
	public WokaymoipDaoSelect(List<DaoStmtExecOption<WokaymoipInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, WokaymoipDaoSelectSingle.class, WokaymoipInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<WokaymoipInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();
	}
}
