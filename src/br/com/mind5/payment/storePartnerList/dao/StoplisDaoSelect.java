package br.com.mind5.payment.storePartnerList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

public final class StoplisDaoSelect implements DaoStmtExec<StoplisInfo> {
	private DaoStmtExec<StoplisInfo> helper;
	
	
	public StoplisDaoSelect(List<DaoStmtExecOption<StoplisInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoplisDaoSelectSingle.class, StoplisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoplisInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
