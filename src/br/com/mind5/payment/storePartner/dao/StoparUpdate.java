package br.com.mind5.payment.storePartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.storePartner.info.StoparInfo;

public final class StoparUpdate implements DaoStmtExec_<StoparInfo> {
	private DaoStmtExec_<StoparInfo> helper;
	
	
	public StoparUpdate(List<DaoStmtExecOption<StoparInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, StoparUpdateSingle.class, StoparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoparInfo> getResultset() {
		return helper.getResultset();
	}
}
