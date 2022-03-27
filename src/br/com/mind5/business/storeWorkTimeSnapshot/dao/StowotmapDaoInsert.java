package br.com.mind5.business.storeWorkTimeSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeWorkTimeSnapshot.info.StowotmapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class StowotmapDaoInsert implements DaoStmtExec<StowotmapInfo> {
	private DaoStmtExec<StowotmapInfo> helper;
	
	
	public StowotmapDaoInsert(List<DaoStmtExecOption<StowotmapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StowotmapDaoInsertSingle.class, StowotmapInfo.class);
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
