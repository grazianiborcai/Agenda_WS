package br.com.mind5.security.userList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.security.userList.info.UselisInfo;

public final class DaoUselisSelect implements DaoStmtExec<UselisInfo> {
	private DaoStmtExec<UselisInfo> helper;
	
	
	public DaoUselisSelect(List<DaoStmtExecOption<UselisInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoUselisSelectSingle.class, UselisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UselisInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
