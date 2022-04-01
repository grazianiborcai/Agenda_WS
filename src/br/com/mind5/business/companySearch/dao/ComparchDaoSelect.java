package br.com.mind5.business.companySearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.companySearch.info.ComparchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class ComparchDaoSelect implements DaoStmtExec<ComparchInfo> {
	private DaoStmtExec<ComparchInfo> helper;
	
	
	public ComparchDaoSelect(List<DaoStmtExecOption<ComparchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, ComparchDaoSelectSingle.class, ComparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<ComparchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
