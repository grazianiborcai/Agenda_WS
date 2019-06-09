package br.com.gda.message.emailBody.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.message.emailBody.info.EmabodyInfo;

public final class EmabodySelect implements DaoStmtExec<EmabodyInfo> {
	private DaoStmtExec<EmabodyInfo> helper;
	
	
	public EmabodySelect(List<DaoStmtExecOption<EmabodyInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmabodySelectSingle.class, EmabodyInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmabodyInfo> getResultset() {
		return helper.getResultset();
	}
}
