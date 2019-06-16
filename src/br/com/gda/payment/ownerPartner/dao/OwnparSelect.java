package br.com.gda.payment.ownerPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payment.ownerPartner.info.OwnparInfo;

public final class OwnparSelect implements DaoStmtExec<OwnparInfo> {
	private DaoStmtExec<OwnparInfo> helper;
	
	
	public OwnparSelect(List<DaoStmtExecOption<OwnparInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, OwnparSelectSingle.class, OwnparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OwnparInfo> getResultset() {
		return helper.getResultset();
	}
}
