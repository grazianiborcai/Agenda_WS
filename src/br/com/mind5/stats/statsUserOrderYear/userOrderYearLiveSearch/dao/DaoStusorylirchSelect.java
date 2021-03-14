package br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsUserOrderYear.userOrderYearLiveSearch.info.StusorylirchInfo;

public final class DaoStusorylirchSelect implements DaoStmtExec<StusorylirchInfo> {
	private DaoStmtExec<StusorylirchInfo> helper;
	
	
	public DaoStusorylirchSelect(List<DaoStmtExecOption<StusorylirchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoStusorylirchSelectSingle.class, StusorylirchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StusorylirchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
