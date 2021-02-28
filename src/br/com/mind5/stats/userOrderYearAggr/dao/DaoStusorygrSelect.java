package br.com.mind5.stats.userOrderYearAggr.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.userOrderYearAggr.info.StusorygrInfo;

public final class DaoStusorygrSelect implements DaoStmtExec<StusorygrInfo> {
	private DaoStmtExec<StusorygrInfo> helper;
	
	
	public DaoStusorygrSelect(List<DaoStmtExecOption<StusorygrInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoStusorygrSelectSingle.class, StusorygrInfo.class);
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
