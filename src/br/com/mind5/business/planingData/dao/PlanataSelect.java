package br.com.mind5.business.planingData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class PlanataSelect implements DaoStmtExec_<PlanataInfo> {
	private DaoStmtExec_<PlanataInfo> helper;
	
	
	public PlanataSelect(List<DaoStmtExecOption<PlanataInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, PlanataSelectSingle.class, PlanataInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PlanataInfo> getResultset() {
		return helper.getResultset();
	}
}
