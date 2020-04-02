package br.com.mind5.security.userPassword.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class UpswdDelete implements DaoStmtExec_<UpswdInfo> {
	private DaoStmtExec_<UpswdInfo> helper;
	
	
	public UpswdDelete(List<DaoStmtExecOption<UpswdInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, UpswdDeleteSingle.class, UpswdInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<UpswdInfo> getResultset() {
		return helper.getResultset();
	}
}
