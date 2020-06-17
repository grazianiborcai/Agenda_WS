package br.com.mind5.security.otpUserPassword.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.security.otpUserPassword.info.OtperasInfo;

public final class DaoOtperasUpdate implements DaoStmtExecV2<OtperasInfo> {
	private DaoStmtExecV2<OtperasInfo> helper;
	
	
	public DaoOtperasUpdate(List<DaoStmtExecOption<OtperasInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoOtperasUpdateSingle.class, OtperasInfo.class);
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