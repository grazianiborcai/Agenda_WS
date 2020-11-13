package br.com.mind5.business.employeeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoEmparchSelect implements DaoStmtExec<EmparchInfo> {
	private DaoStmtExec<EmparchInfo> helper;
	
	
	public DaoEmparchSelect(List<DaoStmtExecOption<EmparchInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoEmparchSelectSingle.class, EmparchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmparchInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
