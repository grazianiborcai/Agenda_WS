package br.com.mind5.business.storeLunchTime.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeLunchTime.info.StuntmInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class StuntmDaoUpdate implements DaoStmtExec<StuntmInfo> {
	private DaoStmtExec<StuntmInfo> helper;
	
	
	public StuntmDaoUpdate(List<DaoStmtExecOption<StuntmInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StuntmDaoUpdateSingle.class, StuntmInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StuntmInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
