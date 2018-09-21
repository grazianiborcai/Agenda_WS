package br.com.gda.business.feeDefault.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.feeDefault.info.FeeDefaultInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class FeeDefaultSelect implements DaoStmtExec<FeeDefaultInfo> {
	private DaoStmtExec<FeeDefaultInfo> helper;
	
	
	public FeeDefaultSelect(List<DaoStmtExecOption<FeeDefaultInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FeeDefaultSelectSingle.class, FeeDefaultInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FeeDefaultInfo> getResultset() {
		return helper.getResultset();
	}
}
