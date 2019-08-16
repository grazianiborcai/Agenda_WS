package br.com.gda.security.userList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.security.userList.info.UselisInfo;

public final class UselisSelect implements DaoStmtExec<UselisInfo> {
	private DaoStmtExec<UselisInfo> helper;
	
	
	public UselisSelect(List<DaoStmtExecOption<UselisInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, UselisSelectSingle.class, UselisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UselisInfo> getResultset() {
		return helper.getResultset();
	}
}
