package br.com.mind5.payment.countryPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;
import br.com.mind5.payment.countryPartner.info.CounparInfo;

public final class CounparSelect implements DaoStmtExec_<CounparInfo> {
	private DaoStmtExec_<CounparInfo> helper;
	
	
	public CounparSelect(List<DaoStmtExecOption<CounparInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, CounparSelectSingle.class, CounparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CounparInfo> getResultset() {
		return helper.getResultset();
	}
}
