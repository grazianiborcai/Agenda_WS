package br.com.mind5.business.employeeLunchTimeConflict.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeLunchTimeConflict.info.EmpulranInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class EmpulranDaoSelect implements DaoStmtExec<EmpulranInfo> {
	private DaoStmtExec<EmpulranInfo> helper;
	
	
	public EmpulranDaoSelect(List<DaoStmtExecOption<EmpulranInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmpulranDaoSelectSingle.class, EmpulranInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpulranInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
