package br.com.gda.business.employeeMaterial.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class EmpmatUpdate implements DaoStmtExec<EmpmatInfo> {
	private DaoStmtExec<EmpmatInfo> helper;
	
	
	public EmpmatUpdate(List<DaoStmtExecOption<EmpmatInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmpmatUpdateSingle.class, EmpmatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpmatInfo> getResultset() {
		return helper.getResultset();
	}
}
