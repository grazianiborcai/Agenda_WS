package br.com.gda.business.company.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class CompDelete implements DaoStmtExec<CompInfo> {
	private DaoStmtExec<CompInfo> helper;
	
	
	public CompDelete(List<DaoStmtExecOption<CompInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CompDeleteSingle.class, CompInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CompInfo> getResultset() {
		return helper.getResultset();
	}
}
