package br.com.gda.security.userSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.security.userSnapshot.info.UserapInfo;

public final class UserapSelect implements DaoStmtExec<UserapInfo> {
	private DaoStmtExec<UserapInfo> helper;
	
	
	public UserapSelect(List<DaoStmtExecOption<UserapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, UserapSelectSingle.class, UserapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UserapInfo> getResultset() {
		return helper.getResultset();
	}
}
