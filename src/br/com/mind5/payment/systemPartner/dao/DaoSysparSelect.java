package br.com.mind5.payment.systemPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class DaoSysparSelect implements DaoStmtExec<SysparInfo> {
	private DaoStmtExec<SysparInfo> helper;
	
	
	public DaoSysparSelect(List<DaoStmtExecOption<SysparInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoSysparSelectSingle.class, SysparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SysparInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
