package br.com.mind5.masterData.paymentPartnerDefault.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.masterData.paymentPartnerDefault.info.PayparultInfo;
import br.com.mind5.dao.DaoStmtExec;

public final class PayparultDaoSelect implements DaoStmtExec<PayparultInfo> {
	private DaoStmtExec<PayparultInfo> helper;
	
	
	public PayparultDaoSelect(List<DaoStmtExecOption<PayparultInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PayparultDaoSelectSingle.class, PayparultInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayparultInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();
	}
}
