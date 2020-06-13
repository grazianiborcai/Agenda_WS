package br.com.mind5.security.otpProspectStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.security.otpProspectStore.info.OtporeInfo;

public final class DaoOtporeInsert implements DaoStmtExecV2<OtporeInfo> {
	private DaoStmtExecV2<OtporeInfo> helper;
	
	
	public DaoOtporeInsert(List<DaoStmtExecOption<OtporeInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoOtporeInsertSingle.class, OtporeInfo.class);
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