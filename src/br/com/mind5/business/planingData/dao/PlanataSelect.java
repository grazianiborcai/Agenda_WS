package br.com.mind5.business.planingData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

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
