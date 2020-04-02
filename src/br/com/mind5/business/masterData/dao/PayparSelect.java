package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class PayparSelect implements DaoStmtExec_<PayparInfo> {
	private DaoStmtExec_<PayparInfo> helper;
	
	
	public PayparSelect(List<DaoStmtExecOption<PayparInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PayparSelectSingle.class, PayparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayparInfo> getResultset() {
		return helper.getResultset();
	}
}
