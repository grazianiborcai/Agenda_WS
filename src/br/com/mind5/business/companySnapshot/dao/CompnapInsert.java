package br.com.mind5.business.companySnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class CompnapInsert implements DaoStmtExec_<CompnapInfo> {
	private DaoStmtExec_<CompnapInfo> helper;
	
	
	public CompnapInsert(List<DaoStmtExecOption<CompnapInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CompnapInsertSingle.class, CompnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CompnapInfo> getResultset() {
		return helper.getResultset();
	}
}
