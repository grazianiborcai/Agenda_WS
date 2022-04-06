package br.com.mind5.business.employeeLeaveDateSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateSearch.info.EmplarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class EmplarchDaoSelect implements DaoStmtExec<EmplarchInfo> {
	private DaoStmtExec<EmplarchInfo> helper;
	
	
	public EmplarchDaoSelect(List<DaoStmtExecOption<EmplarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmplarchDaoSelectSingle.class, EmplarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmplarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();
	}
}
