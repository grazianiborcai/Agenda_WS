package br.com.gda.business.planingData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.planingData.info.PlanataInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class PlanataSelect implements DaoStmtExec<PlanataInfo> {
	private DaoStmtExec<PlanataInfo> helper;
	
	
	public PlanataSelect(List<DaoStmtExecOption<PlanataInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PlanataSelectSingle.class, PlanataInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PlanataInfo> getResultset() {
		return helper.getResultset();
	}
}
