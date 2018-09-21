package br.com.gda.business.feeStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.feeStore.info.FeeStoreInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class FeeStoreSelect implements DaoStmtExec<FeeStoreInfo> {
	private DaoStmtExec<FeeStoreInfo> helper;
	
	
	public FeeStoreSelect(List<DaoStmtExecOption<FeeStoreInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FeeStoreSelectSingle.class, FeeStoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FeeStoreInfo> getResultset() {
		return helper.getResultset();
	}
}
