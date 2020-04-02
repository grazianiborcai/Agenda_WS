package br.com.mind5.payment.payOrderItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordemUpdate implements DaoStmtExec_<PayordemInfo> {
	private DaoStmtExec_<PayordemInfo> helper;
	
	
	public PayordemUpdate(List<DaoStmtExecOption<PayordemInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PayordemUpdateSingle.class, PayordemInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayordemInfo> getResultset() {
		return helper.getResultset();
	}
}
