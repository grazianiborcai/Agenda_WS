package br.com.mind5.security.userSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.security.userSearch.info.UserarchInfo;

public final class DaoUserarchSelect implements DaoStmtExec<UserarchInfo> {
	private DaoStmtExec<UserarchInfo> helper;
	
	
	public DaoUserarchSelect(List<DaoStmtExecOption<UserarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoUserarchSelectSingle.class, UserarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UserarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
