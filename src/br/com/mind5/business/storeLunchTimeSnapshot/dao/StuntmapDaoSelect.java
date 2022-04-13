package br.com.mind5.business.storeLunchTimeSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeLunchTimeSnapshot.info.StuntmapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class StuntmapDaoSelect implements DaoStmtExec<StuntmapInfo> {
	private DaoStmtExec<StuntmapInfo> helper;
	
	
	public StuntmapDaoSelect(List<DaoStmtExecOption<StuntmapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StuntmapDaoSelectSingle.class, StuntmapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StuntmapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
