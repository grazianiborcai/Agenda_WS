package br.com.mind5.security.userSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.security.userSearch.info.UserarchInfo;

public final class UserarchSelect implements DaoStmtExec_<UserarchInfo> {
	private DaoStmtExec_<UserarchInfo> helper;
	
	
	public UserarchSelect(List<DaoStmtExecOption<UserarchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, UserarchSelectSingle.class, UserarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UserarchInfo> getResultset() {
		return helper.getResultset();
	}
}
