package br.com.mind5.business.employeeMaterial.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoEmpmatSelect implements DaoStmtExec<EmpmatInfo> {
	private DaoStmtExec<EmpmatInfo> helper;
	
	
	public DaoEmpmatSelect(List<DaoStmtExecOption<EmpmatInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoEmpmatSelectSingle.class, EmpmatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpmatInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
