package br.com.mind5.message.emailBody.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmabodySelect implements DaoStmtExec_<EmabodyInfo> {
	private DaoStmtExec_<EmabodyInfo> helper;
	
	
	public EmabodySelect(List<DaoStmtExecOption<EmabodyInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, EmabodySelectSingle.class, EmabodyInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmabodyInfo> getResultset() {
		return helper.getResultset();
	}
}
