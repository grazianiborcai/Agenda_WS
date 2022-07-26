package br.com.mind5.message.emailBody.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.message.emailBody.info.EmabodyInfo;

public final class EmabodyDaoSelect implements DaoStmtExec<EmabodyInfo> {
	private DaoStmtExec<EmabodyInfo> helper;
	
	
	public EmabodyDaoSelect(List<DaoStmtExecOption<EmabodyInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmabodyDaoSelectSingle.class, EmabodyInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmabodyInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
