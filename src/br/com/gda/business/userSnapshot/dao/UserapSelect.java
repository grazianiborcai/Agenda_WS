package br.com.gda.business.userSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.userSnapshot.info.UserapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

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
