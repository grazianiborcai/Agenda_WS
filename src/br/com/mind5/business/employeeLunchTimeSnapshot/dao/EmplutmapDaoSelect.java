package br.com.mind5.business.employeeLunchTimeSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeLunchTimeSnapshot.info.EmplutmapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class EmplutmapDaoSelect implements DaoStmtExec<EmplutmapInfo> {
	private DaoStmtExec<EmplutmapInfo> helper;
	
	
	public EmplutmapDaoSelect(List<DaoStmtExecOption<EmplutmapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmplutmapDaoSelectSingle.class, EmplutmapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmplutmapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
