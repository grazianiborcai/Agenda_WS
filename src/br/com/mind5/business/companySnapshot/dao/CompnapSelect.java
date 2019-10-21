package br.com.mind5.business.companySnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

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
