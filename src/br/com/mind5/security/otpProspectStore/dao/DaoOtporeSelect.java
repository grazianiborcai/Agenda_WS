package br.com.mind5.security.otpProspectStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

public class DaoOtporeSelect implements DaoStmtExec<OtporeInfo> {
	private DaoStmtExec<OtporeInfo> helper;
	
	
	public DaoOtporeSelect(List<DaoStmtExecOption<OtporeInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoOtporeSelectSingle.class, OtporeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OtporeInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
