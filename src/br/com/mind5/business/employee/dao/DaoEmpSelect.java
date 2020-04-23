package br.com.mind5.business.employee.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoEmpSelect implements DaoStmtExecV2<EmpInfo> {
	private DaoStmtExecV2<EmpInfo> helper;
	
	
	public DaoEmpSelect(List<DaoStmtExecOption<EmpInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmpSelectSingle.class, EmpInfo.class);
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
