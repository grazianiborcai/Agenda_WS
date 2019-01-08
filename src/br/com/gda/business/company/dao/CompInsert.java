package br.com.gda.business.company.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class CompInsert implements DaoStmtExec<CompInfo> {
	private DaoStmtExec<CompInfo> helper;
	
	
	public CompInsert(List<DaoStmtExecOption<CompInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CompInsertSingle.class, CompInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CompInfo> getResultset() {
		return helper.getResultset();
	}
}
