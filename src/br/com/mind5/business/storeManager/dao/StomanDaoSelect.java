package br.com.mind5.business.storeManager.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeManager.info.StomanInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class StomanDaoSelect implements DaoStmtExec<StomanInfo> {
	private DaoStmtExec<StomanInfo> helper;
	
	
	public StomanDaoSelect(List<DaoStmtExecOption<StomanInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StomanDaoSelectSingle.class, StomanInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StomanInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
