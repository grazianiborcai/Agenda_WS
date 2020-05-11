package br.com.mind5.security.user.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.security.user.info.UserInfo;

public final class DaoUserSelect implements DaoStmtExecV2<UserInfo> {
	private DaoStmtExecV2<UserInfo> helper;
	
	
	public DaoUserSelect(List<DaoStmtExecOption<UserInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoUserSelectSingle.class, UserInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UserInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
