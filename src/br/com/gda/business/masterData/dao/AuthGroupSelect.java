package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.AuthGroupInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public class AuthGroupSelect implements DaoStmtExec<AuthGroupInfo> {
	private DaoStmtExec<AuthGroupInfo> helper;
	
	
	public AuthGroupSelect(List<DaoStmtExecOption<AuthGroupInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, AuthGroupSelectSingle.class, AuthGroupInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<AuthGroupInfo> getResultset() {
		return helper.getResultset();
	}
}
