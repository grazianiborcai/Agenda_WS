package br.com.mind5.payment.storePartnerList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

public final class StoplisSelect implements DaoStmtExec_<StoplisInfo> {
	private DaoStmtExec_<StoplisInfo> helper;
	
	
	public StoplisSelect(List<DaoStmtExecOption<StoplisInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, StoplisSelectSingle.class, StoplisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoplisInfo> getResultset() {
		return helper.getResultset();
	}
}
