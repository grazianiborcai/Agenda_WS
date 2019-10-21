package br.com.mind5.business.storeLeaveDate.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class StolateUpdate implements DaoStmtExec<StolateInfo> {
	private DaoStmtExec<StolateInfo> helper;
	
	
	public StolateUpdate(List<DaoStmtExecOption<StolateInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StolateUpdateSingle.class, StolateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StolateInfo> getResultset() {
		return helper.getResultset();
	}
}
