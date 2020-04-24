package br.com.mind5.payment.storePartnerList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.storePartnerList.info.StoplisInfo;

public final class DaoStoplisSelect implements DaoStmtExecV2<StoplisInfo> {
	private DaoStmtExecV2<StoplisInfo> helper;
	
	
	public DaoStoplisSelect(List<DaoStmtExecOption<StoplisInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStoplisSelectSingle.class, StoplisInfo.class);
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
