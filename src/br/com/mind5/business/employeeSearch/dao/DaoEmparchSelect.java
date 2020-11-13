package br.com.mind5.business.employeeSearch.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoEmparchSelect implements DaoStmtExecV2<EmparchInfo> {
	private DaoStmtExecV2<EmparchInfo> helper;
	
	
	public DaoEmparchSelect(List<DaoStmtExecOption<EmparchInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmparchSelectSingle.class, EmparchInfo.class);
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
