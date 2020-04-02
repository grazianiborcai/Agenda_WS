package br.com.mind5.business.companyConflict.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class CompcoSelect implements DaoStmtExec_<CompcoInfo> {
	private DaoStmtExec_<CompcoInfo> helper;
	
	
	public CompcoSelect(List<DaoStmtExecOption<CompcoInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CompcoSelectSingle.class, CompcoInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CompcoInfo> getResultset() {
		return helper.getResultset();
	}
}
