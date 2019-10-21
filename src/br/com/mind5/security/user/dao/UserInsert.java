package br.com.mind5.security.user.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.security.user.info.UserInfo;

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
