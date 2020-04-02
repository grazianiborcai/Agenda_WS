package br.com.mind5.webhook.moipMultipayment.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.webhook.moipMultipayment.info.WokaymoipInfo;

public final class WokaymoipSelect implements DaoStmtExec_<WokaymoipInfo> {
	private DaoStmtExec_<WokaymoipInfo> helper;
	
	
	public WokaymoipSelect(List<DaoStmtExecOption<WokaymoipInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, WokaymoipSelectSingle.class, WokaymoipInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<WokaymoipInfo> getResultset() {
		return helper.getResultset();
	}
}
