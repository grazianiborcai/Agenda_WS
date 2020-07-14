package br.com.mind5.business.employeeSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeSnapshot.info.EmpnapInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoEmpnapInsert implements DaoStmtExecV2<EmpnapInfo> {
	private DaoStmtExecV2<EmpnapInfo> helper;
	
	
	public DaoEmpnapInsert(List<DaoStmtExecOption<EmpnapInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmpnapInsertSingle.class, EmpnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpnapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
