package br.com.gda.payment.storePartnerSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class StoparnapSelect implements DaoStmtExec<StoparnapInfo> {
	private DaoStmtExec<StoparnapInfo> helper;
	
	
	public StoparnapSelect(List<DaoStmtExecOption<StoparnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoparnapSelectSingle.class, StoparnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoparnapInfo> getResultset() {
		return helper.getResultset();
	}
}
