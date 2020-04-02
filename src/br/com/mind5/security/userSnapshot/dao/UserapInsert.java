package br.com.mind5.security.userSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class UserapInsert implements DaoStmtExec_<UserapInfo> {
	private DaoStmtExec_<UserapInfo> helper;
	
	
	public UserapInsert(List<DaoStmtExecOption<UserapInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, UserapInsertSingle.class, UserapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UserapInfo> getResultset() {
		return helper.getResultset();
	}
}
