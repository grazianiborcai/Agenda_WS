package br.com.mind5.business.refundPolicyOwnerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;
import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupownarchInfo;

public final class DaoRefupownarchSelect implements DaoStmtExecV2<RefupownarchInfo> {
	private DaoStmtExecV2<RefupownarchInfo> helper;
	
	
	public DaoRefupownarchSelect(List<DaoStmtExecOption<RefupownarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoRefupownarchSelectSingle.class, RefupownarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<RefupownarchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
