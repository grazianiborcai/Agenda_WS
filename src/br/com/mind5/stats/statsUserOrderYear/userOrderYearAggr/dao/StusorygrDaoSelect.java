package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggr.info.StusorygrInfo;

public final class StusorygrDaoSelect implements DaoStmtExec<StusorygrInfo> {
	private DaoStmtExec<StusorygrInfo> helper;
	
	
	public StusorygrDaoSelect(List<DaoStmtExecOption<StusorygrInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StusorygrDaoSelectSingle.class, StusorygrInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StusorygrInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
