package br.com.mind5.config.sysOwnerConfig.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.config.sysOwnerConfig.info.SysonfigInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoSysonfigSelect implements DaoStmtExecV2<SysonfigInfo> {
	private DaoStmtExecV2<SysonfigInfo> helper;
	
	
	public DaoSysonfigSelect(List<DaoStmtExecOption<SysonfigInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSysonfigSelectSingle.class, SysonfigInfo.class);
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
