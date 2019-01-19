package br.com.gda.payService.payCustomer.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payService.payCustomer.info.PaycusInfo;

public final class PaycusDelete implements DaoStmtExec<PaycusInfo> {
	private DaoStmtExec<PaycusInfo> helper;
	
	
	public PaycusDelete(List<DaoStmtExecOption<PaycusInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PaycusDeleteSingle.class, PaycusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PaycusInfo> getResultset() {
		return helper.getResultset();
	}
}
