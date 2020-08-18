package br.com.mind5.business.employeeMaterial.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.dao.DaoStmtExecHelperV2;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExecV2;

public final class DaoEmpmatUpdate implements DaoStmtExecV2<EmpmatInfo> {
	private DaoStmtExecV2<EmpmatInfo> helper;
	
	
	public DaoEmpmatUpdate(List<DaoStmtExecOption<EmpmatInfo>> options) {
		helper = new DaoStmtExecHelperV2<>(options, DaoEmpmatUpdateSingle.class, EmpmatInfo.class);
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
