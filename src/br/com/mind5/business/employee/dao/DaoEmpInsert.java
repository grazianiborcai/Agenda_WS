package br.com.mind5.business.employee.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoEmpInsert implements DaoStmtExec<EmpInfo> {
	private DaoStmtExec<EmpInfo> helper;
	
	
	public DaoEmpInsert(List<DaoStmtExecOption<EmpInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoEmpInsertSingle.class, EmpInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
