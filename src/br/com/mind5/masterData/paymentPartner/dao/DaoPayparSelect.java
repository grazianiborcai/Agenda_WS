package br.com.mind5.masterData.paymentPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;

public final class DaoPayparSelect implements DaoStmtExec<PayparInfo> {
	private DaoStmtExec<PayparInfo> helper;
	
	
	public DaoPayparSelect(List<DaoStmtExecOption<PayparInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPayparSelectSingle.class, PayparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayparInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();
	}
}
