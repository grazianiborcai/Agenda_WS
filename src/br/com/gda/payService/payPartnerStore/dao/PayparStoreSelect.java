package br.com.gda.payService.payPartnerStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payService.payPartnerStore.info.PayparStoreInfo;

public final class PayparStoreSelect implements DaoStmtExec<PayparStoreInfo> {
	private DaoStmtExec<PayparStoreInfo> helper;
	
	
	public PayparStoreSelect(List<DaoStmtExecOption<PayparStoreInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PayparStoreSelectSingle.class, PayparStoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayparStoreInfo> getResultset() {
		return helper.getResultset();
	}
}
