package br.com.mind5.business.company.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class CompInsert implements DaoStmtExec_<CompInfo> {
	private DaoStmtExec_<CompInfo> helper;
	
	
	public CompInsert(List<DaoStmtExecOption<CompInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CompInsertSingle.class, CompInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CompInfo> getResultset() {
		return helper.getResultset();
	}
}
