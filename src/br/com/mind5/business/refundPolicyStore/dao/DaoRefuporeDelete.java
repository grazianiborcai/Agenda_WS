package br.com.mind5.business.refundPolicyStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoRefuporeDelete implements DaoStmtExec<RefuporeInfo> {
	private DaoStmtExec<RefuporeInfo> helper;
	
	
	public DaoRefuporeDelete(List<DaoStmtExecOption<RefuporeInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoRefuporeDeleteSingle.class, RefuporeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<RefuporeInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
