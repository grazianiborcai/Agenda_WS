package br.com.mind5.business.employeeWorkTimeConflict.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeWorkTimeConflict.info.EmpwocoInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoEmpwocoSelect implements DaoStmtExecV2<EmpwocoInfo> {
	private DaoStmtExecV2<EmpwocoInfo> helper;
	
	
	public DaoEmpwocoSelect(List<DaoStmtExecOption<EmpwocoInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmpwocoSelectSingle.class, EmpwocoInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpwocoInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
