package br.com.gda.business.schedule.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.schedule.info.ScheduInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class ScheduInsert implements DaoStmtExec<ScheduInfo> {
	private DaoStmtExec<ScheduInfo> helper;
	
	
	public ScheduInsert(List<DaoStmtExecOption<ScheduInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, ScheduInsertSingle.class, ScheduInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<ScheduInfo> getResultset() {
		return helper.getResultset();
	}
}
