package br.com.mind5.payment.storePartnerSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class StoparnapDaoSelect implements DaoStmtExec<StoparnapInfo> {
	private DaoStmtExec<StoparnapInfo> helper;
	
	
	public StoparnapDaoSelect(List<DaoStmtExecOption<StoparnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoparnapDaoSelectSingle.class, StoparnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StoparnapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
