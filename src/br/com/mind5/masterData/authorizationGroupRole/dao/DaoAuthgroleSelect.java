package br.com.mind5.masterData.authorizationGroupRole.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.masterData.authorizationGroupRole.info.AuthgroleInfo;

public class DaoAuthgroleSelect implements DaoStmtExec<AuthgroleInfo> {
	private DaoStmtExec<AuthgroleInfo> helper;
	
	
	public DaoAuthgroleSelect(List<DaoStmtExecOption<AuthgroleInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoAuthgroleSelectSingle.class, AuthgroleInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<AuthgroleInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
