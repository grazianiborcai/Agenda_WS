package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.PayPartnerInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class PayPartnerSelect implements DaoStmtExec<PayPartnerInfo> {
	private DaoStmtExec<PayPartnerInfo> helper;
	
	
	public PayPartnerSelect(List<DaoStmtExecOption<PayPartnerInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PayPartnerSelectSingle.class, PayPartnerInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PayPartnerInfo> getResultset() {
		return helper.getResultset();
	}
}
