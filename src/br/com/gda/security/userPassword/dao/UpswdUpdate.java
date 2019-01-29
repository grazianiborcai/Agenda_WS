package br.com.gda.security.userPassword.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.security.userPassword.info.UpswdInfo;

public final class UpswdUpdate implements DaoStmtExec<UpswdInfo> {
	private DaoStmtExec<UpswdInfo> helper;
	
	
	public UpswdUpdate(List<DaoStmtExecOption<UpswdInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, UpswdUpdateSingle.class, UpswdInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UpswdInfo> getResultset() {
		return helper.getResultset();
	}
}
