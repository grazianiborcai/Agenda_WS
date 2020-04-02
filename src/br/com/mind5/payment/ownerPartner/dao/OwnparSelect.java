package br.com.mind5.payment.ownerPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

public final class OwnparSelect implements DaoStmtExec_<OwnparInfo> {
	private DaoStmtExec_<OwnparInfo> helper;
	
	
	public OwnparSelect(List<DaoStmtExecOption<OwnparInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, OwnparSelectSingle.class, OwnparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OwnparInfo> getResultset() {
		return helper.getResultset();
	}
}
