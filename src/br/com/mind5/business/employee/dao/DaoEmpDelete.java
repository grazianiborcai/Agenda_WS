package br.com.mind5.business.employee.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoEmpDelete implements DaoStmtExecV2<EmpInfo> {
	private DaoStmtExecV2<EmpInfo> helper;
	
	
	public DaoEmpDelete(List<DaoStmtExecOption<EmpInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmpDeleteSingle.class, EmpInfo.class);
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
