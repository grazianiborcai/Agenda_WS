package br.com.gda.business.phoneSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class PhoneSnapSelect implements DaoStmtExec<PhoneSnapInfo> {
	private DaoStmtExec<PhoneSnapInfo> helper;
	
	
	public PhoneSnapSelect(List<DaoStmtExecOption<PhoneSnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PhoneSnapSelectSingle.class, PhoneSnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PhoneSnapInfo> getResultset() {
		return helper.getResultset();
	}
}
