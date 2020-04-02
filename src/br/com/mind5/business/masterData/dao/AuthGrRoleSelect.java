package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public class AuthGrRoleSelect implements DaoStmtExec_<AuthGrRoleInfo> {
	private DaoStmtExec_<AuthGrRoleInfo> helper;
	
	
	public AuthGrRoleSelect(List<DaoStmtExecOption<AuthGrRoleInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, AuthGrRoleSelectSingle.class, AuthGrRoleInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<AuthGrRoleInfo> getResultset() {
		return helper.getResultset();
	}
}
