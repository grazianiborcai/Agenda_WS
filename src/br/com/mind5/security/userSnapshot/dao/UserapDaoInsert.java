package br.com.mind5.security.userSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.security.userSnapshot.info.UserapInfo;

public final class UserapDaoInsert implements DaoStmtExec<UserapInfo> {
	private DaoStmtExec<UserapInfo> helper;
	
	
	public UserapDaoInsert(List<DaoStmtExecOption<UserapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, UserapDaoInsertSingle.class, UserapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UserapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
