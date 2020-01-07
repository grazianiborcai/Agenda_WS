package br.com.mind5.business.employeeLeaveDateRange.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeLeaveDateRange.info.EmplargInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class EmplargSelect implements DaoStmtExec<EmplargInfo> {
	private DaoStmtExec<EmplargInfo> helper;
	
	
	public EmplargSelect(List<DaoStmtExecOption<EmplargInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmplargSelectSingle.class, EmplargInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmplargInfo> getResultset() {
		return helper.getResultset();
	}
}
