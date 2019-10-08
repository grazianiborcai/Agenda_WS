package br.com.gda.business.storeLeaveDate.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.storeLeaveDate.info.StolevateInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class StolevateInsert implements DaoStmtExec<StolevateInfo> {
	private DaoStmtExec<StolevateInfo> helper;
	
	
	public StolevateInsert(List<DaoStmtExecOption<StolevateInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StolevateInsertSingle.class, StolevateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StolevateInfo> getResultset() {
		return helper.getResultset();
	}
}
