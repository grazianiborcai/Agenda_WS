package br.com.mind5.payment.payOrderItemSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class PayormarchSelect implements DaoStmtExec_<PayormarchInfo> {
	private DaoStmtExec_<PayormarchInfo> helper;
	
	
	public PayormarchSelect(List<DaoStmtExecOption<PayormarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PayormarchSelectSingle.class, PayormarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayormarchInfo> getResultset() {
		return helper.getResultset();
	}
}
