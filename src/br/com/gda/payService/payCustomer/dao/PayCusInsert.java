package br.com.gda.payService.payCustomer.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payService.payCustomer.info.PayCusInfo;

public final class PayCusInsert implements DaoStmtExec<PayCusInfo> {
	private DaoStmtExec<PayCusInfo> helper;
	
	
	public PayCusInsert(List<DaoStmtExecOption<PayCusInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PayCusInsertSingle.class, PayCusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayCusInfo> getResultset() {
		return helper.getResultset();
	}
}
