package br.com.mind5.business.employeePosition.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class EmposInsert implements DaoStmtExec<EmposInfo> {
	private DaoStmtExec<EmposInfo> helper;
	
	
	public EmposInsert(List<DaoStmtExecOption<EmposInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmposInsertSingle.class, EmposInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<EmposInfo> getResultset() {
		return helper.getResultset();
	}
}
