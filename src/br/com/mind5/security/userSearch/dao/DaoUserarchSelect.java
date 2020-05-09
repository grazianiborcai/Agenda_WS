package br.com.mind5.security.userSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.security.userSearch.info.UserarchInfo;

public final class DaoUserarchSelect implements DaoStmtExecV2<UserarchInfo> {
	private DaoStmtExecV2<UserarchInfo> helper;
	
	
	public DaoUserarchSelect(List<DaoStmtExecOption<UserarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoUserarchSelectSingle.class, UserarchInfo.class);
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
