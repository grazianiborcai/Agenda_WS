package br.com.mind5.payment.countryPartnerSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;

public final class CounparchSelect implements DaoStmtExec_<CounparchInfo> {
	private DaoStmtExec_<CounparchInfo> helper;
	
	
	public CounparchSelect(List<DaoStmtExecOption<CounparchInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CounparchSelectSingle.class, CounparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CounparchInfo> getResultset() {
		return helper.getResultset();
	}
}
