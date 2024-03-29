package br.com.mind5.security.username.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.security.username.info.UsernameInfo;

public final class UsernameDaoSelect implements DaoStmtExec<UsernameInfo> {
	private DaoStmtExec<UsernameInfo> helper;
	
	
	public UsernameDaoSelect(List<DaoStmtExecOption<UsernameInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, UsernameDaoSelectSingle.class, UsernameInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UsernameInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
