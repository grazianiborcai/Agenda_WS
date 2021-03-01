package br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearStgnSearch.info.StusorygerchInfo;

public final class DaoStusorygerchSelect implements DaoStmtExec<StusorygerchInfo> {
	private DaoStmtExec<StusorygerchInfo> helper;
	
	
	public DaoStusorygerchSelect(List<DaoStmtExecOption<StusorygerchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoStusorygerchSelectSingle.class, StusorygerchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StusorygerchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
