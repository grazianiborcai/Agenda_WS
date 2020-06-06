package br.com.mind5.business.employeeWorkTimeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeSearch.info.EmpwotarchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoEmpwotarchSelect implements DaoStmtExecV2<EmpwotarchInfo> {
	private DaoStmtExecV2<EmpwotarchInfo> helper;
	
	
	public DaoEmpwotarchSelect(List<DaoStmtExecOption<EmpwotarchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmpwotarchSelectSingle.class, EmpwotarchInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpwotarchInfo> getResultset() {
		return helper.getResultset();
	}



	@Override public void close() {
		helper.close();		
	}
}
