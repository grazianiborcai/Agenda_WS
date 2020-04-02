package br.com.mind5.payment.payOrderSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.payOrderSearch.info.PayordarchInfo;

public final class PayordarchSelect implements DaoStmtExec_<PayordarchInfo> {
	private DaoStmtExec_<PayordarchInfo> helper;
	
	
	public PayordarchSelect(List<DaoStmtExecOption<PayordarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PayordarchSelectSingle.class, PayordarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayordarchInfo> getResultset() {
		return helper.getResultset();
	}
}
