package br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserMonthSearch.info.SowusarchInfo;

public final class SowusarchDaoSelect implements DaoStmtExec<SowusarchInfo> {
	private DaoStmtExec<SowusarchInfo> helper;
	
	
	public SowusarchDaoSelect(List<DaoStmtExecOption<SowusarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SowusarchDaoSelectSingle.class, SowusarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
	}

	
	
	@Override public List<SowusarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();
	}
}
