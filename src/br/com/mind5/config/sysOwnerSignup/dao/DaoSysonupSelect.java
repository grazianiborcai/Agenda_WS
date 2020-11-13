package br.com.mind5.config.sysOwnerSignup.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;

public final class DaoSysonupSelect implements DaoStmtExec<SysonupInfo> {
	private DaoStmtExec<SysonupInfo> helper;
	
	
	public DaoSysonupSelect(List<DaoStmtExecOption<SysonupInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSysonupSelectSingle.class, SysonupInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SysonupInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
