package br.com.mind5.business.refundPolicyOwnerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupowarchInfo;

public final class DaoRefupowarchSelect implements DaoStmtExecV2<RefupowarchInfo> {
	private DaoStmtExecV2<RefupowarchInfo> helper;
	
	
	public DaoRefupowarchSelect(List<DaoStmtExecOption<RefupowarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoRefupowarchSelectSingle.class, RefupowarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<RefupowarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
