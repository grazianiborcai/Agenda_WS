package br.com.mind5.security.username.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.security.username.info.UsernameInfo;

public final class UsernameSelect implements DaoStmtExec_<UsernameInfo> {
	private DaoStmtExec_<UsernameInfo> helper;
	
	
	public UsernameSelect(List<DaoStmtExecOption<UsernameInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, UsernameSelectSingle.class, UsernameInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UsernameInfo> getResultset() {
		return helper.getResultset();
	}
}
