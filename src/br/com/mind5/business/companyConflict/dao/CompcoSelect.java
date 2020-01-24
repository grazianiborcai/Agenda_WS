package br.com.mind5.business.companyConflict.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class CompcoSelect implements DaoStmtExec<CompcoInfo> {
	private DaoStmtExec<CompcoInfo> helper;
	
	
	public CompcoSelect(List<DaoStmtExecOption<CompcoInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CompcoSelectSingle.class, CompcoInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CompcoInfo> getResultset() {
		return helper.getResultset();
	}
}
