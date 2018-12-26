package br.com.gda.payService.payPartnerStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payService.payPartnerStore.info.PayPartnerStoreInfo;

public final class PayPartnerStoreSelect implements DaoStmtExec<PayPartnerStoreInfo> {
	private DaoStmtExec<PayPartnerStoreInfo> helper;
	
	
	public PayPartnerStoreSelect(List<DaoStmtExecOption<PayPartnerStoreInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PayPartnerStoreSelectSingle.class, PayPartnerStoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayPartnerStoreInfo> getResultset() {
		return helper.getResultset();
	}
}
