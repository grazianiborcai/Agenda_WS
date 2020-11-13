package br.com.mind5.business.companyConflict.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.companyConflict.info.CompcoInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoCompcoSelect implements DaoStmtExec<CompcoInfo> {
	private DaoStmtExec<CompcoInfo> helper;
	
	
	public DaoCompcoSelect(List<DaoStmtExecOption<CompcoInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoCompcoSelectSingle.class, CompcoInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CompcoInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
