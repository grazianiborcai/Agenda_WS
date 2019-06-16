package br.com.gda.payment.customer.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.payment.customer.info.PaycusInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class PaycusUpdate implements DaoStmtExec<PaycusInfo> {
	private DaoStmtExec<PaycusInfo> helper;
	
	
	public PaycusUpdate(List<DaoStmtExecOption<PaycusInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PaycusUpdateSingle.class, PaycusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PaycusInfo> getResultset() {
		return helper.getResultset();
	}
}
