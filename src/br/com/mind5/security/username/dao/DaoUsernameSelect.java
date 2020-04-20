package br.com.mind5.security.username.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.security.username.info.UsernameInfo;

public final class DaoUsernameSelect implements DaoStmtExecV2<UsernameInfo> {
	private DaoStmtExecV2<UsernameInfo> helper;
	
	
	public DaoUsernameSelect(List<DaoStmtExecOption<UsernameInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoUsernameSelectSingle.class, UsernameInfo.class);
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
