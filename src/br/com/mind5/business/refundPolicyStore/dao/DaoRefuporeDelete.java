package br.com.mind5.business.refundPolicyStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.refundPolicyStore.info.RefuporeInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoRefuporeDelete implements DaoStmtExecV2<RefuporeInfo> {
	private DaoStmtExecV2<RefuporeInfo> helper;
	
	
	public DaoRefuporeDelete(List<DaoStmtExecOption<RefuporeInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoRefuporeDeleteSingle.class, RefuporeInfo.class);
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
