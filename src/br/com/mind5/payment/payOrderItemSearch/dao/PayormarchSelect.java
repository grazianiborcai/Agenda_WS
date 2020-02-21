package br.com.mind5.payment.payOrderItemSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.payment.payOrderItemSearch.info.PayormarchInfo;

public final class PayormarchSelect implements DaoStmtExec<PayormarchInfo> {
	private DaoStmtExec<PayormarchInfo> helper;
	
	
	public PayormarchSelect(List<DaoStmtExecOption<PayormarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PayormarchSelectSingle.class, PayormarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayormarchInfo> getResultset() {
		return helper.getResultset();
	}
}
