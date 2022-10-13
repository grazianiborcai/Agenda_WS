package br.com.mind5.business.personLegal.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.personLegal.info.PeregInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class PeregDaoUpdate implements DaoStmtExec<PeregInfo> {
	private DaoStmtExec<PeregInfo> helper;
	
	
	public PeregDaoUpdate(List<DaoStmtExecOption<PeregInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PeregDaoUpdateSingle.class, PeregInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PeregInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
