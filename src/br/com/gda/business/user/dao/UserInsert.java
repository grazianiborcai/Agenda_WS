package br.com.gda.business.user.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class UserInsert implements DaoStmtExec<UserInfo> {
	private DaoStmtExec<UserInfo> helper;
	
	
	public UserInsert(List<DaoStmtExecOption<UserInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, UserInsertSingle.class, UserInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UserInfo> getResultset() {
		return helper.getResultset();
	}
}
