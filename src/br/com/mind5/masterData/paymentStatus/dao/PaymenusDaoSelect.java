package br.com.mind5.masterData.paymentStatus.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.paymentStatus.info.PaymenusInfo;

public final class PaymenusDaoSelect implements DaoStmtExec<PaymenusInfo> {
	private DaoStmtExec<PaymenusInfo> helper;
	
	
	public PaymenusDaoSelect(List<DaoStmtExecOption<PaymenusInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PaymenusDaoSelectSingle.class, PaymenusInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PaymenusInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
