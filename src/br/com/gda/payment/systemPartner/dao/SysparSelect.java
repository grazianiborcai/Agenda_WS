package br.com.gda.payment.systemPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payment.systemPartner.info.SysparInfo;

public final class SysparSelect implements DaoStmtExec<SysparInfo> {
	private DaoStmtExec<SysparInfo> helper;
	
	
	public SysparSelect(List<DaoStmtExecOption<SysparInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SysparSelectSingle.class, SysparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SysparInfo> getResultset() {
		return helper.getResultset();
	}
}
