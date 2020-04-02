package br.com.mind5.business.employeePosition.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class EmposUpdate implements DaoStmtExec_<EmposInfo> {
	private DaoStmtExec_<EmposInfo> helper;
	
	
	public EmposUpdate(List<DaoStmtExecOption<EmposInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, EmposUpdateSingle.class, EmposInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmposInfo> getResultset() {
		return helper.getResultset();
	}
}
