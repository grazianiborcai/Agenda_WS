package br.com.mind5.masterData.paymentPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;

public final class DaoPayparSelect implements DaoStmtExecV2<PayparInfo> {
	private DaoStmtExecV2<PayparInfo> helper;
	
	
	public DaoPayparSelect(List<DaoStmtExecOption<PayparInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPayparSelectSingle.class, PayparInfo.class);
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
