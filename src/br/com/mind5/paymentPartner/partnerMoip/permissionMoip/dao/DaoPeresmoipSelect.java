package br.com.mind5.paymentPartner.partnerMoip.permissionMoip.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.paymentPartner.partnerMoip.permissionMoip.info.PeresmoipInfo;

public final class DaoPeresmoipSelect implements DaoStmtExecV2<PeresmoipInfo> {
	private DaoStmtExecV2<PeresmoipInfo> helper;
	
	
	public DaoPeresmoipSelect(List<DaoStmtExecOption<PeresmoipInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoPeresmoipSelectSingle.class, PeresmoipInfo.class);
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
