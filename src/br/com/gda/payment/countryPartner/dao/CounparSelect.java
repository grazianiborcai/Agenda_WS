package br.com.gda.payment.countryPartner.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;
import br.com.gda.payment.countryPartner.info.CounparInfo;

public final class CounparSelect implements DaoStmtExec<CounparInfo> {
	private DaoStmtExec<CounparInfo> helper;
	
	
	public CounparSelect(List<DaoStmtExecOption<CounparInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, CounparSelectSingle.class, CounparInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<CounparInfo> getResultset() {
		return helper.getResultset();
	}
}
