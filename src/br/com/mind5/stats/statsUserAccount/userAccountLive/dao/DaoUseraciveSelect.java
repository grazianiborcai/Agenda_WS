package br.com.mind5.stats.statsUserAccount.userAccountLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.UseraciveInfo;

public final class DaoUseraciveSelect implements DaoStmtExec<UseraciveInfo> {
	private DaoStmtExec<UseraciveInfo> helper;
	
	
	public DaoUseraciveSelect(List<DaoStmtExecOption<UseraciveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoUseraciveSelectSingle.class, UseraciveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UseraciveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
