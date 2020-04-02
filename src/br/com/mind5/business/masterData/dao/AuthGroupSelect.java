package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.AuthGroupInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public class AuthGroupSelect implements DaoStmtExec_<AuthGroupInfo> {
	private DaoStmtExec_<AuthGroupInfo> helper;
	
	
	public AuthGroupSelect(List<DaoStmtExecOption<AuthGroupInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, AuthGroupSelectSingle.class, AuthGroupInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<AuthGroupInfo> getResultset() {
		return helper.getResultset();
	}
}
