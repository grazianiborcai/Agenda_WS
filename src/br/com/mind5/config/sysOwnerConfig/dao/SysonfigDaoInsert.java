package br.com.mind5.config.sysOwnerConfig.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class SysonfigDaoInsert implements DaoStmtExec<SysonfigInfo> {
	private DaoStmtExec<SysonfigInfo> helper;
	
	
	public SysonfigDaoInsert(List<DaoStmtExecOption<SysonfigInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SysonfigDaoInsertSingle.class, SysonfigInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SysonfigInfo> getResultset() {
		return helper.getResultset();
	}


	
	@Override public void close() {
		helper.close();		
	}
}
