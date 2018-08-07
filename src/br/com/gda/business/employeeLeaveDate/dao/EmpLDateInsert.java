package br.com.gda.business.employeeLeaveDate.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.employeeLeaveDate.info.EmpLDateInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class EmpLDateInsert implements DaoStmtExec<EmpLDateInfo> {
	private DaoStmtExec<EmpLDateInfo> helper;
	
	
	public EmpLDateInsert(List<DaoStmtExecOption<EmpLDateInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmpLDateInsertSingle.class, EmpLDateInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<EmpLDateInfo> getResultset() {
		return helper.getResultset();
	}
}
