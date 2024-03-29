package br.com.mind5.business.storeLeaveDateSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class StolarchDaoSelect implements DaoStmtExec<StolarchInfo> {
	private DaoStmtExec<StolarchInfo> helper;
	
	
	public StolarchDaoSelect(List<DaoStmtExecOption<StolarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StolarchDaoSelectSingle.class, StolarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StolarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
