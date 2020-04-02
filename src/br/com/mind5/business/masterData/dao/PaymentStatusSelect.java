package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.PaymentStatusInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class PaymentStatusSelect implements DaoStmtExec_<PaymentStatusInfo> {
	private DaoStmtExec_<PaymentStatusInfo> helper;
	
	
	public PaymentStatusSelect(List<DaoStmtExecOption<PaymentStatusInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PaymentStatusSelectSingle.class, PaymentStatusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PaymentStatusInfo> getResultset() {
		return helper.getResultset();
	}
}
