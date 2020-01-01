package br.com.mind5.payment.storePartnerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

public final class StoparchSelect implements DaoStmtExec<StoparchInfo> {
	private DaoStmtExec<StoparchInfo> helper;
	
	
	public StoparchSelect(List<DaoStmtExecOption<StoparchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoparchSelectSingle.class, StoparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoparchInfo> getResultset() {
		return helper.getResultset();
	}
}
