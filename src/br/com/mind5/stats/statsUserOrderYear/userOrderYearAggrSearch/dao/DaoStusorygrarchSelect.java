package br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearAggrSearch.info.StusorygrarchInfo;

public final class DaoStusorygrarchSelect implements DaoStmtExec<StusorygrarchInfo> {
	private DaoStmtExec<StusorygrarchInfo> helper;
	
	
	public DaoStusorygrarchSelect(List<DaoStmtExecOption<StusorygrarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoStusorygrarchSelectSingle.class, StusorygrarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StusorygrarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
