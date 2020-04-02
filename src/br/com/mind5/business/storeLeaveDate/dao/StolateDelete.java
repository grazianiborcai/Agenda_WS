package br.com.mind5.business.storeLeaveDate.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeLeaveDate.info.StolateInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class StolateDelete implements DaoStmtExec_<StolateInfo> {
	private DaoStmtExec_<StolateInfo> helper;
	
	
	public StolateDelete(List<DaoStmtExecOption<StolateInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, StolateDeleteSingle.class, StolateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<StolateInfo> getResultset() {
		return helper.getResultset();
	}
}
