package br.com.gda.payment.payOrder.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payment.payOrder.info.PayordInfo;

public final class PayordUpdate implements DaoStmtExec<PayordInfo> {
	private DaoStmtExec<PayordInfo> helper;
	
	
	public PayordUpdate(List<DaoStmtExecOption<PayordInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PayordUpdateSingle.class, PayordInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayordInfo> getResultset() {
		return helper.getResultset();
	}
}
