package br.com.gda.business.feeStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.feeStore.info.FeetoreInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class FeetoreSelect implements DaoStmtExec<FeetoreInfo> {
	private DaoStmtExec<FeetoreInfo> helper;
	
	
	public FeetoreSelect(List<DaoStmtExecOption<FeetoreInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FeetoreSelectSingle.class, FeetoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FeetoreInfo> getResultset() {
		return helper.getResultset();
	}
}
