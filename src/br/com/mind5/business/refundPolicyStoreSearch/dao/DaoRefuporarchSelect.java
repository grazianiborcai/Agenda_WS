package br.com.mind5.business.refundPolicyStoreSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoRefuporarchSelect implements DaoStmtExecV2<RefuporarchInfo> {
	private DaoStmtExecV2<RefuporarchInfo> helper;
	
	
	public DaoRefuporarchSelect(List<DaoStmtExecOption<RefuporarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoRefuporarchSelectSingle.class, RefuporarchInfo.class);
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
