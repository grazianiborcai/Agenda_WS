package br.com.gda.business.feeDefault.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.feeDefault.info.FeedefInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class FeedefSelect implements DaoStmtExec<FeedefInfo> {
	private DaoStmtExec<FeedefInfo> helper;
	
	
	public FeedefSelect(List<DaoStmtExecOption<FeedefInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FeedefSelectSingle.class, FeedefInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FeedefInfo> getResultset() {
		return helper.getResultset();
	}
}
