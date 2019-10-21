package br.com.mind5.security.user.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.security.user.info.UserInfo;

public final class UserUpdate implements DaoStmtExec<UserInfo> {
	private DaoStmtExec<UserInfo> helper;
	
	
	public UserUpdate(List<DaoStmtExecOption<UserInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, UserUpdateSingle.class, UserInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UserInfo> getResultset() {
		return helper.getResultset();
	}
}
