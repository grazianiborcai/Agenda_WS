package br.com.mind5.business.refundPolicyStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;

public final class RefuporeDaoSelect implements DaoStmtExec<RefuporeInfo> {
	private DaoStmtExec<RefuporeInfo> helper;
	
	
	public RefuporeDaoSelect(List<DaoStmtExecOption<RefuporeInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, RefuporeDaoSelectSingle.class, RefuporeInfo.class);
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
