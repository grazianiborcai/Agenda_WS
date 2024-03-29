package br.com.mind5.business.companySnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class CompnapDaoInsert implements DaoStmtExec<CompnapInfo> {
	private DaoStmtExec<CompnapInfo> helper;
	
	
	public CompnapDaoInsert(List<DaoStmtExecOption<CompnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CompnapDaoInsertSingle.class, CompnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CompnapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
