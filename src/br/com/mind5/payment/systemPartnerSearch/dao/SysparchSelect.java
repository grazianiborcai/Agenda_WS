package br.com.mind5.payment.systemPartnerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchInfo;

public final class SysparchSelect implements DaoStmtExec<SysparchInfo> {
	private DaoStmtExec<SysparchInfo> helper;
	
	
	public SysparchSelect(List<DaoStmtExecOption<SysparchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SysparchSelectSingle.class, SysparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SysparchInfo> getResultset() {
		return helper.getResultset();
	}
}
