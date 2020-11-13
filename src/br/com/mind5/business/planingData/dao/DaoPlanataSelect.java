package br.com.mind5.business.planingData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.planingData.info.PlanataInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoPlanataSelect implements DaoStmtExec<PlanataInfo> {
	private DaoStmtExec<PlanataInfo> helper;
	
	
	public DaoPlanataSelect(List<DaoStmtExecOption<PlanataInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoPlanataSelectSingle.class, PlanataInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PlanataInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
