package br.com.mind5.business.refundPolicyStoreSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class RefuporarchDaoSelect implements DaoStmtExec<RefuporarchInfo> {
	private DaoStmtExec<RefuporarchInfo> helper;
	
	
	public RefuporarchDaoSelect(List<DaoStmtExecOption<RefuporarchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, RefuporarchDaoSelectSingle.class, RefuporarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<RefuporarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
