package br.com.mind5.payment.payOrderList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;

public final class PayordistSelect implements DaoStmtExec_<PayordistInfo> {
	private DaoStmtExec_<PayordistInfo> helper;
	
	
	public PayordistSelect(List<DaoStmtExecOption<PayordistInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PayordistSelectSingle.class, PayordistInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayordistInfo> getResultset() {
		return helper.getResultset();
	}
}
