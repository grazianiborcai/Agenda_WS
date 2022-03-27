package br.com.mind5.business.storeWorkTimeSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSnapshot.info.StowotmapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class StowotmapDaoSelect implements DaoStmtExec<StowotmapInfo> {
	private DaoStmtExec<StowotmapInfo> helper;
	
	
	public StowotmapDaoSelect(List<DaoStmtExecOption<StowotmapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StowotmapDaoSelectSingle.class, StowotmapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StowotmapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
