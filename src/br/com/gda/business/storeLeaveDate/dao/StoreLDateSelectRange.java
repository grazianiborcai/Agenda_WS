package br.com.gda.business.storeLeaveDate.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class StoreLDateSelectRange implements DaoStmtExec<StoreLDateInfo> {
	private DaoStmtExec<StoreLDateInfo> helper;
	
	
	public StoreLDateSelectRange(List<DaoStmtExecOption<StoreLDateInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoreLDateSelectRangeSingle.class, StoreLDateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StoreLDateInfo> getResultset() {
		return helper.getResultset();
	}
}
