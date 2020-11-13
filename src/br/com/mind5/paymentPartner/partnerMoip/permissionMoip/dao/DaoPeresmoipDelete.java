package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class DaoPeresmoipDelete implements DaoStmtExec<PeresmoipInfo> {
	private DaoStmtExec<PeresmoipInfo> helper;
	
	
	public DaoPeresmoipDelete(List<DaoStmtExecOption<PeresmoipInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPeresmoipDeleteSingle.class, PeresmoipInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PeresmoipInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
