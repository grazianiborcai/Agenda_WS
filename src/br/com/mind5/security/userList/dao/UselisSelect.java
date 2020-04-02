package br.com.mind5.security.userList.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.security.userList.info.UselisInfo;

public final class UselisSelect implements DaoStmtExec_<UselisInfo> {
	private DaoStmtExec_<UselisInfo> helper;
	
	
	public UselisSelect(List<DaoStmtExecOption<UselisInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, UselisSelectSingle.class, UselisInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UselisInfo> getResultset() {
		return helper.getResultset();
	}
}
