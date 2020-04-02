package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.SysEnvironInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class SysEnvironSelect implements DaoStmtExec_<SysEnvironInfo> {
	private DaoStmtExec_<SysEnvironInfo> helper;
	
	
	public SysEnvironSelect(List<DaoStmtExecOption<SysEnvironInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, SysEnvironSelectSingle.class, SysEnvironInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SysEnvironInfo> getResultset() {
		return helper.getResultset();
	}
}
