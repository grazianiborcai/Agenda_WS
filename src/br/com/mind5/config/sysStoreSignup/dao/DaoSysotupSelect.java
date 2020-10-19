package br.com.mind5.config.sysStoreSignup.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.config.sysStoreSignup.info.SysotupInfo;

public final class DaoSysotupSelect implements DaoStmtExecV2<SysotupInfo> {
	private DaoStmtExecV2<SysotupInfo> helper;
	
	
	public DaoSysotupSelect(List<DaoStmtExecOption<SysotupInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSysotupSelectSingle.class, SysotupInfo.class);
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
