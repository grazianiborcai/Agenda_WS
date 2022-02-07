package br.com.mind5.stats.statsOwnerStore.ownerStoreLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsOwnerStore.ownerStoreLive.info.SowotiveInfo;

public final class DaoSowotiveSelect implements DaoStmtExec<SowotiveInfo> {
	private DaoStmtExec<SowotiveInfo> helper;
	
	
	public DaoSowotiveSelect(List<DaoStmtExecOption<SowotiveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSowotiveSelectSingle.class, SowotiveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SowotiveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
