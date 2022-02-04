package br.com.mind5.stats.statsUserAccount.userAccountLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsUserAccount.userAccountLive.info.SuseraciveInfo;

public final class DaoSuseraciveSelect implements DaoStmtExec<SuseraciveInfo> {
	private DaoStmtExec<SuseraciveInfo> helper;
	
	
	public DaoSuseraciveSelect(List<DaoStmtExecOption<SuseraciveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSuseraciveSelectSingle.class, SuseraciveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SuseraciveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
