package br.com.mind5.business.scheduleReserve.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.scheduleReserve.info.SchederveInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class SchederveDaoSelect implements DaoStmtExec<SchederveInfo> {
	private DaoStmtExec<SchederveInfo> helper;
	
	
	public SchederveDaoSelect(List<DaoStmtExecOption<SchederveInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, SchederveDaoSelectSingle.class, SchederveInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<SchederveInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
