package br.com.gda.business.snapshot_.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.snapshot_.info.SnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class SnapInsert implements DaoStmtExec<SnapInfo> {
	private DaoStmtExec<SnapInfo> helper;
	
	
	public SnapInsert(List<DaoStmtExecOption<SnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SnapInsertSingle.class, SnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SnapInfo> getResultset() {
		return helper.getResultset();
	}
}
