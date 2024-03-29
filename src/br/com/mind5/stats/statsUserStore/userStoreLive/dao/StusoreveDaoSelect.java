package br.com.mind5.stats.statsUserStore.userStoreLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsUserStore.userStoreLive.info.StusoreveInfo;

public final class StusoreveDaoSelect implements DaoStmtExec<StusoreveInfo> {
	private DaoStmtExec<StusoreveInfo> helper;
	
	
	public StusoreveDaoSelect(List<DaoStmtExecOption<StusoreveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StusoreveDaoSelectSingle.class, StusoreveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StusoreveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
