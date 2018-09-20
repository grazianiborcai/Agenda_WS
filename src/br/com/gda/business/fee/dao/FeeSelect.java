package br.com.gda.business.fee.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.fee.info.FeeInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class FeeSelect implements DaoStmtExec<FeeInfo> {
	private DaoStmtExec<FeeInfo> helper;
	
	
	public FeeSelect(List<DaoStmtExecOption<FeeInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FeeSelectSingle.class, FeeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FeeInfo> getResultset() {
		return helper.getResultset();
	}
}
