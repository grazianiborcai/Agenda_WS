package br.com.gda.payment.payOrderSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payment.payOrderSearch.info.PayordarchInfo;

public final class PayordarchSelect implements DaoStmtExec<PayordarchInfo> {
	private DaoStmtExec<PayordarchInfo> helper;
	
	
	public PayordarchSelect(List<DaoStmtExecOption<PayordarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PayordarchSelectSingle.class, PayordarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayordarchInfo> getResultset() {
		return helper.getResultset();
	}
}
