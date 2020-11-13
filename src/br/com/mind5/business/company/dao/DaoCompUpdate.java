package br.com.mind5.business.company.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.company.info.CompInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoCompUpdate implements DaoStmtExec<CompInfo> {
	private DaoStmtExec<CompInfo> helper;
	
	
	public DaoCompUpdate(List<DaoStmtExecOption<CompInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoCompUpdateSingle.class, CompInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CompInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
