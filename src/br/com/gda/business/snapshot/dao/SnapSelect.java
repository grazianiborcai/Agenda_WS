package br.com.gda.business.snapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class SnapSelect implements DaoStmtExec<SnapInfo> {
	private DaoStmtExec<SnapInfo> helper;
	
	
	public SnapSelect(List<DaoStmtExecOption<SnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SnapSelectSingle.class, SnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SnapInfo> getResultset() {
		return helper.getResultset();
	}
}
