package br.com.gda.business.employeeWorkTime.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class EmpwotmDelete implements DaoStmtExec<EmpwotmInfo> {
	private DaoStmtExec<EmpwotmInfo> helper;
	
	
	public EmpwotmDelete(List<DaoStmtExecOption<EmpwotmInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmpwotmDeleteSingle.class, EmpwotmInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpwotmInfo> getResultset() {
		return helper.getResultset();
	}
}
