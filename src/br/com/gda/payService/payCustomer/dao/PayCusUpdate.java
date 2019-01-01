package br.com.gda.payService.payCustomer.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class PayCusUpdate implements DaoStmtExec<PayCusInfo> {
	private DaoStmtExec<PayCusInfo> helper;
	
	
	public PayCusUpdate(List<DaoStmtExecOption<PayCusInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PayCusUpdateSingle.class, PayCusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayCusInfo> getResultset() {
		return helper.getResultset();
	}
}
