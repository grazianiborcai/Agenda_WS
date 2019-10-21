package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.UserCategInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class UserCategSelect implements DaoStmtExec<UserCategInfo> {
	private DaoStmtExec<UserCategInfo> helper;
	
	
	public UserCategSelect(List<DaoStmtExecOption<UserCategInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, UserCategSelectSingle.class, UserCategInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UserCategInfo> getResultset() {
		return helper.getResultset();
	}
}
