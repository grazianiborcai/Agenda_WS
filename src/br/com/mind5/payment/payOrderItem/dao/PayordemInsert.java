package br.com.mind5.payment.payOrderItem.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;

public final class PayordemInsert implements DaoStmtExec_<PayordemInfo> {
	private DaoStmtExec_<PayordemInfo> helper;
	
	
	public PayordemInsert(List<DaoStmtExecOption<PayordemInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PayordemInsertSingle.class, PayordemInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayordemInfo> getResultset() {
		return helper.getResultset();
	}
}
