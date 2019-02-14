package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public class AuthGrRoleSelect implements DaoStmtExec<AuthGrRoleInfo> {
	private DaoStmtExec<AuthGrRoleInfo> helper;
	
	
	public AuthGrRoleSelect(List<DaoStmtExecOption<AuthGrRoleInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, AuthGrRoleSelectSingle.class, AuthGrRoleInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<AuthGrRoleInfo> getResultset() {
		return helper.getResultset();
	}
}
