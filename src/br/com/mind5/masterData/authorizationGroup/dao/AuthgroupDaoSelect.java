package br.com.mind5.masterData.authorizationGroup.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.authorizationGroup.info.AuthgroupInfo;

public class AuthgroupDaoSelect implements DaoStmtExec<AuthgroupInfo> {
	private DaoStmtExec<AuthgroupInfo> helper;
	
	
	public AuthgroupDaoSelect(List<DaoStmtExecOption<AuthgroupInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, AuthgroupDaoSelectSingle.class, AuthgroupInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<AuthgroupInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
