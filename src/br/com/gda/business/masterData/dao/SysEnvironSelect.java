package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.SysEnvironInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class SysEnvironSelect implements DaoStmtExec<SysEnvironInfo> {
	private DaoStmtExec<SysEnvironInfo> helper;
	
	
	public SysEnvironSelect(List<DaoStmtExecOption<SysEnvironInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SysEnvironSelectSingle.class, SysEnvironInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SysEnvironInfo> getResultset() {
		return helper.getResultset();
	}
}
