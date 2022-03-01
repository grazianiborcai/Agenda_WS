package br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsOwnerOrder.ownerOrderMonthSearch.info.SowordarchInfo;

public final class SowordarchDaoSelect implements DaoStmtExec<SowordarchInfo> {
	private DaoStmtExec<SowordarchInfo> helper;
	
	
	public SowordarchDaoSelect(List<DaoStmtExecOption<SowordarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SowordarchDaoSelectSingle.class, SowordarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
	}

	
	
	@Override public List<SowordarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();
	}
}
