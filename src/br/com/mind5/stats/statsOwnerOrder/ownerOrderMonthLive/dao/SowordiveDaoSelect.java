package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthLive.info.SowordiveInfo;

public final class SowordiveDaoSelect implements DaoStmtExec<SowordiveInfo> {
	private DaoStmtExec<SowordiveInfo> helper;
	
	
	public SowordiveDaoSelect(List<DaoStmtExecOption<SowordiveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SowordiveDaoSelectSingle.class, SowordiveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SowordiveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
