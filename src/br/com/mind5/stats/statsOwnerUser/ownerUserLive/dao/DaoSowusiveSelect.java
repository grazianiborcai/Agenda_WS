package br.com.mind5.stats.statsOwnerUser.ownerUserLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsOwnerUser.ownerUserLive.info.SowusiveInfo;

public final class DaoSowusiveSelect implements DaoStmtExec<SowusiveInfo> {
	private DaoStmtExec<SowusiveInfo> helper;
	
	
	public DaoSowusiveSelect(List<DaoStmtExecOption<SowusiveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSowusiveSelectSingle.class, SowusiveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SowusiveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
