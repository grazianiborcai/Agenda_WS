package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.BusinessInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class BusinessSelect implements DaoStmtExec_<BusinessInfo> {
	private DaoStmtExec_<BusinessInfo> helper;
	
	
	public BusinessSelect(List<DaoStmtExecOption<BusinessInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, BusinessSelectSingle.class, BusinessInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<BusinessInfo> getResultset() {
		return helper.getResultset();
	}
}
