package br.com.mind5.business.storeLunchTimeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeLunchTimeSearch.info.StuntmarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class StuntmarchDaoSelect implements DaoStmtExec<StuntmarchInfo> {
	private DaoStmtExec<StuntmarchInfo> helper;
	
	
	public StuntmarchDaoSelect(List<DaoStmtExecOption<StuntmarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StuntmarchDaoSelectSingle.class, StuntmarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StuntmarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
