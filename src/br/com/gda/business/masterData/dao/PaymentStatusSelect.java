package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.PaymentStatusInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class PaymentStatusSelect implements DaoStmtExec<PaymentStatusInfo> {
	private DaoStmtExec<PaymentStatusInfo> helper;
	
	
	public PaymentStatusSelect(List<DaoStmtExecOption<PaymentStatusInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PaymentStatusSelectSingle.class, PaymentStatusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PaymentStatusInfo> getResultset() {
		return helper.getResultset();
	}
}
