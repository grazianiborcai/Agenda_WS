package br.com.gda.business.storeLeaveDateSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class StolarchSelect implements DaoStmtExec<StolarchInfo> {
	private DaoStmtExec<StolarchInfo> helper;
	
	
	public StolarchSelect(List<DaoStmtExecOption<StolarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StolarchSelectSingle.class, StolarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StolarchInfo> getResultset() {
		return helper.getResultset();
	}
}
