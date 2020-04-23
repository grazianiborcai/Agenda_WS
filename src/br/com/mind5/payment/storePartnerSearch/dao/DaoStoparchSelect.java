package br.com.mind5.payment.storePartnerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.storePartnerSearch.info.StoparchInfo;

public final class DaoStoparchSelect implements DaoStmtExecV2<StoparchInfo> {
	private DaoStmtExecV2<StoparchInfo> helper;
	
	
	public DaoStoparchSelect(List<DaoStmtExecOption<StoparchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStoparchSelectSingle.class, StoparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoparchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
