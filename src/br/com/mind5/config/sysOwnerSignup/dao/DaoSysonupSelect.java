package br.com.mind5.config.sysOwnerSignup.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.config.sysOwnerSignup.info.SysonupInfo;

public final class DaoSysonupSelect implements DaoStmtExecV2<SysonupInfo> {
	private DaoStmtExecV2<SysonupInfo> helper;
	
	
	public DaoSysonupSelect(List<DaoStmtExecOption<SysonupInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoSysonupSelectSingle.class, SysonupInfo.class);
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
