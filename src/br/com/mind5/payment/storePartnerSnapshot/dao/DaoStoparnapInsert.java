package br.com.mind5.payment.storePartnerSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.payment.storePartnerSnapshot.info.StoparnapInfo;

public final class DaoStoparnapInsert implements DaoStmtExecV2<StoparnapInfo> {
	private DaoStmtExecV2<StoparnapInfo> helper;
	
	
	public DaoStoparnapInsert(List<DaoStmtExecOption<StoparnapInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoStoparnapInsertSingle.class, StoparnapInfo.class);
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
