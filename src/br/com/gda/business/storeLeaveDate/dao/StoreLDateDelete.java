package br.com.gda.business.storeLeaveDate.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StoreLDateInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class StoreLDateDelete implements DaoStmtExec<StoreLDateInfo> {
	private DaoStmtExec<StoreLDateInfo> helper;
	
	
	public StoreLDateDelete(List<DaoStmtExecOption<StoreLDateInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StoreLDateDeleteSingle.class, StoreLDateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StoreLDateInfo> getResultset() {
		return helper.getResultset();
	}
}
