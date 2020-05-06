package br.com.mind5.business.refundPolicyStoreSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporerchInfo;

public final class DaoRefuporerchSelect implements DaoStmtExecV2<RefuporerchInfo> {
	private DaoStmtExecV2<RefuporerchInfo> helper;
	
	
	public DaoRefuporerchSelect(List<DaoStmtExecOption<RefuporerchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoRefuporerchSelectSingle.class, RefuporerchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<RefuporerchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
