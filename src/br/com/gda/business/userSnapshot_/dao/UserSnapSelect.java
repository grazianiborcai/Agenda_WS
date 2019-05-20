package br.com.gda.business.userSnapshot_.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.userSnapshot_.info.UserSnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class UserSnapSelect implements DaoStmtExec<UserSnapInfo> {
	private DaoStmtExec<UserSnapInfo> helper;
	
	
	public UserSnapSelect(List<DaoStmtExecOption<UserSnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, UserSnapSelectSingle.class, UserSnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UserSnapInfo> getResultset() {
		return helper.getResultset();
	}
}
