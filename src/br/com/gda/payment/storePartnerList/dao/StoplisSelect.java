package br.com.gda.payment.storePartnerList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payment.storePartnerList.info.StoplisInfo;

public final class StoplisSelect implements DaoStmtExec<StoplisInfo> {
	private DaoStmtExec<StoplisInfo> helper;
	
	
	public StoplisSelect(List<DaoStmtExecOption<StoplisInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoplisSelectSingle.class, StoplisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoplisInfo> getResultset() {
		return helper.getResultset();
	}
}
