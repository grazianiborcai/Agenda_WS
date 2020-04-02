package br.com.mind5.payment.systemPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.systemPartner.info.SysparInfo;

public final class SysparSelect implements DaoStmtExec_<SysparInfo> {
	private DaoStmtExec_<SysparInfo> helper;
	
	
	public SysparSelect(List<DaoStmtExecOption<SysparInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, SysparSelectSingle.class, SysparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SysparInfo> getResultset() {
		return helper.getResultset();
	}
}
