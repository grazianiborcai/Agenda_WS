package br.com.mind5.payment.ownerPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.payment.ownerPartner.info.OwnparInfo;

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
