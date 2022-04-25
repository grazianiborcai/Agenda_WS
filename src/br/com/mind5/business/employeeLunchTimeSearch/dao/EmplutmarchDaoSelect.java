package br.com.mind5.business.employeeLunchTimeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeLunchTimeSearch.info.EmplutmarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class EmplutmarchDaoSelect implements DaoStmtExec<EmplutmarchInfo> {
	private DaoStmtExec<EmplutmarchInfo> helper;
	
	
	public EmplutmarchDaoSelect(List<DaoStmtExecOption<EmplutmarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmplutmarchDaoSelectSingle.class, EmplutmarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmplutmarchInfo> getResultset() {
		return helper.getResultset();
	}



	@Override public void close() {
		helper.close();		
	}
}
