package br.com.mind5.payment.payOrder.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.payment.payOrder.info.PayordInfo;

public final class PayordInsert implements DaoStmtExec<PayordInfo> {
	private DaoStmtExec<PayordInfo> helper;
	
	
	public PayordInsert(List<DaoStmtExecOption<PayordInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PayordInsertSingle.class, PayordInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayordInfo> getResultset() {
		return helper.getResultset();
	}
}
