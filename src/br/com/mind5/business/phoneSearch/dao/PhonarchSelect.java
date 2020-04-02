package br.com.mind5.business.phoneSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.phoneSearch.info.PhonarchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class PhonarchSelect implements DaoStmtExec_<PhonarchInfo> {
	private DaoStmtExec_<PhonarchInfo> helper;
	
	
	public PhonarchSelect(List<DaoStmtExecOption<PhonarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PhonarchSelectSingle.class, PhonarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PhonarchInfo> getResultset() {
		return helper.getResultset();
	}
}
