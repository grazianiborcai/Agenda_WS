package br.com.mind5.business.refundPolicyOwner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoRefupownUpdate implements DaoStmtExec<RefupownInfo> {
	private DaoStmtExec<RefupownInfo> helper;
	
	
	public DaoRefupownUpdate(List<DaoStmtExecOption<RefupownInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoRefupownUpdateSingle.class, RefupownInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<RefupownInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
