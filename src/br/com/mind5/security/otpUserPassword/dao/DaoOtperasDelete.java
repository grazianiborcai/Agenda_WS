package br.com.mind5.security.otpUserPassword.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

public final class DaoOtperasDelete implements DaoStmtExec<OtperasInfo> {
	private DaoStmtExec<OtperasInfo> helper;
	
	
	public DaoOtperasDelete(List<DaoStmtExecOption<OtperasInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoOtperasDeleteSingle.class, OtperasInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OtperasInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
