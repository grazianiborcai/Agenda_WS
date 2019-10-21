package br.com.mind5.business.employeeSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class EmpnapInsert implements DaoStmtExec<EmpnapInfo> {
	private DaoStmtExec<EmpnapInfo> helper;
	
	
	public EmpnapInsert(List<DaoStmtExecOption<EmpnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmpnapInsertSingle.class, EmpnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpnapInfo> getResultset() {
		return helper.getResultset();
	}
}
