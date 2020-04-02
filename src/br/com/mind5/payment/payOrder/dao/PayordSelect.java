package br.com.mind5.payment.payOrder.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordSelect implements DaoStmtExec_<PayordInfo> {
	private DaoStmtExec_<PayordInfo> helper;
	
	
	public PayordSelect(List<DaoStmtExecOption<PayordInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PayordSelectSingle.class, PayordInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayordInfo> getResultset() {
		return helper.getResultset();
	}
}
