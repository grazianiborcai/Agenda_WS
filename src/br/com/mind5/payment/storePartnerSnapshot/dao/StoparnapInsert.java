package br.com.mind5.payment.storePartnerSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class StoparnapInsert implements DaoStmtExec_<StoparnapInfo> {
	private DaoStmtExec_<StoparnapInfo> helper;
	
	
	public StoparnapInsert(List<DaoStmtExecOption<StoparnapInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, StoparnapInsertSingle.class, StoparnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoparnapInfo> getResultset() {
		return helper.getResultset();
	}
}
