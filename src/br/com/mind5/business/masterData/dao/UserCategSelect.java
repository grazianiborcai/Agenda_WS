package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.UserCategInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class UserCategSelect implements DaoStmtExec_<UserCategInfo> {
	private DaoStmtExec_<UserCategInfo> helper;
	
	
	public UserCategSelect(List<DaoStmtExecOption<UserCategInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, UserCategSelectSingle.class, UserCategInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<UserCategInfo> getResultset() {
		return helper.getResultset();
	}
}
