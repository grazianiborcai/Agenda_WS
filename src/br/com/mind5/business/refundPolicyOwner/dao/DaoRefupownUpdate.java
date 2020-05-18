package br.com.mind5.business.refundPolicyOwner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoRefupownUpdate implements DaoStmtExecV2<RefupownInfo> {
	private DaoStmtExecV2<RefupownInfo> helper;
	
	
	public DaoRefupownUpdate(List<DaoStmtExecOption<RefupownInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoRefupownUpdateSingle.class, RefupownInfo.class);
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
