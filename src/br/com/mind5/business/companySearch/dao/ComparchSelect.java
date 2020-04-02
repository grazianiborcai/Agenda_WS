package br.com.mind5.business.companySearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class ComparchSelect implements DaoStmtExec_<ComparchInfo> {
	private DaoStmtExec_<ComparchInfo> helper;
	
	
	public ComparchSelect(List<DaoStmtExecOption<ComparchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, ComparchSelectSingle.class, ComparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<ComparchInfo> getResultset() {
		return helper.getResultset();
	}
}
