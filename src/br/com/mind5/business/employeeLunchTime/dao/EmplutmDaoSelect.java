package br.com.mind5.business.employeeLunchTime.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeLunchTime.info.EmplutmInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class EmplutmDaoSelect implements DaoStmtExec<EmplutmInfo> {
	private DaoStmtExec<EmplutmInfo> helper;
	
	
	public EmplutmDaoSelect(List<DaoStmtExecOption<EmplutmInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmplutmDaoSelectSingle.class, EmplutmInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmplutmInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
