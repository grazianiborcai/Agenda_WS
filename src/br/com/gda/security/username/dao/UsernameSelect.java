package br.com.gda.security.username.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.security.username.info.UsernameInfo;

public final class UsernameSelect implements DaoStmtExec<UsernameInfo> {
	private DaoStmtExec<UsernameInfo> helper;
	
	
	public UsernameSelect(List<DaoStmtExecOption<UsernameInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, UsernameSelectSingle.class, UsernameInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UsernameInfo> getResultset() {
		return helper.getResultset();
	}
}
