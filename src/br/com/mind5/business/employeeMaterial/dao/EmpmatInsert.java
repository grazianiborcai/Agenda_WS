package br.com.mind5.business.employeeMaterial.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class EmpmatInsert implements DaoStmtExec<EmpmatInfo> {
	private DaoStmtExec<EmpmatInfo> helper;
	
	
	public EmpmatInsert(List<DaoStmtExecOption<EmpmatInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, EmpmatInsertSingle.class, EmpmatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpmatInfo> getResultset() {
		return helper.getResultset();
	}
}
