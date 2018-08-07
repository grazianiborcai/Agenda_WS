package br.com.gda.business.employeeWorkTime.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpWTimeInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class EmpWTimeInsert implements DaoStmtExec<EmpWTimeInfo> {	
	private DaoStmtExec<EmpWTimeInfo> helper;
	
	
	public EmpWTimeInsert(List<DaoStmtExecOption<EmpWTimeInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmpWTimeInsertSingle.class, EmpWTimeInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<EmpWTimeInfo> getResultset() {
		return helper.getResultset();
	}
}