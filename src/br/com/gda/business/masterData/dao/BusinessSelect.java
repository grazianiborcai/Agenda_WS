package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.BusinessInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class BusinessSelect implements DaoStmtExec<BusinessInfo> {
	private DaoStmtExec<BusinessInfo> helper;
	
	
	public BusinessSelect(List<DaoStmtExecOption<BusinessInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, BusinessSelectSingle.class, BusinessInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<BusinessInfo> getResultset() {
		return helper.getResultset();
	}
}
