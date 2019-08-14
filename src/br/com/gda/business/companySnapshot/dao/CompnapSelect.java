package br.com.gda.business.companySnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.companySnapshot.info.CompnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class CompnapSelect implements DaoStmtExec<CompnapInfo> {
	private DaoStmtExec<CompnapInfo> helper;
	
	
	public CompnapSelect(List<DaoStmtExecOption<CompnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CompnapSelectSingle.class, CompnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CompnapInfo> getResultset() {
		return helper.getResultset();
	}
}
