package br.com.mind5.payment.systemPartnerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.systemPartnerSearch.info.SysparchInfo;

public final class SysparchSelect implements DaoStmtExec_<SysparchInfo> {
	private DaoStmtExec_<SysparchInfo> helper;
	
	
	public SysparchSelect(List<DaoStmtExecOption<SysparchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, SysparchSelectSingle.class, SysparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SysparchInfo> getResultset() {
		return helper.getResultset();
	}
}
