package br.com.gda.business.phoneSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.phoneSearch.info.PhonarchInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class PhonarchSelect implements DaoStmtExec<PhonarchInfo> {
	private DaoStmtExec<PhonarchInfo> helper;
	
	
	public PhonarchSelect(List<DaoStmtExecOption<PhonarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PhonarchSelectSingle.class, PhonarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PhonarchInfo> getResultset() {
		return helper.getResultset();
	}
}
