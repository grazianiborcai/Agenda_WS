package br.com.mind5.payment.creditCard.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.creditCard.info.CrecardInfo;

public final class CrecardSelect implements DaoStmtExec_<CrecardInfo> {
	private DaoStmtExec_<CrecardInfo> helper;
	
	
	public CrecardSelect(List<DaoStmtExecOption<CrecardInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CrecardSelectSingle.class, CrecardInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CrecardInfo> getResultset() {
		return helper.getResultset();
	}
}
