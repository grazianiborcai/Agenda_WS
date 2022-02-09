package br.com.mind5.stats.statsOwnerSchedule.ownerScheduleLive.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.stats.statsOwnerSchedule.ownerScheduleLive.info.SoweduliveInfo;

public final class DaoSoweduliveSelect implements DaoStmtExec<SoweduliveInfo> {
	private DaoStmtExec<SoweduliveInfo> helper;
	
	
	public DaoSoweduliveSelect(List<DaoStmtExecOption<SoweduliveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSoweduliveSelectSingle.class, SoweduliveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SoweduliveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
