package br.com.mind5.config.sysStoreSignup.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;

public final class SysotupDaoSelect implements DaoStmtExec<SysotupInfo> {
	private DaoStmtExec<SysotupInfo> helper;
	
	
	public SysotupDaoSelect(List<DaoStmtExecOption<SysotupInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SysotupDaoSelectSingle.class, SysotupInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SysotupInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
