package br.com.mind5.payment.payOrderItemList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.payOrderItemList.info.PayordemistInfo;

public final class PayordemistSelect implements DaoStmtExec_<PayordemistInfo> {
	private DaoStmtExec_<PayordemistInfo> helper;
	
	
	public PayordemistSelect(List<DaoStmtExecOption<PayordemistInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PayordemistSelectSingle.class, PayordemistInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayordemistInfo> getResultset() {
		return helper.getResultset();
	}
}
