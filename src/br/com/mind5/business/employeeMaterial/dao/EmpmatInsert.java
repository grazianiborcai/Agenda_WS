package br.com.mind5.business.employeeMaterial.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.employeeMaterial.info.EmpmatInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class EmpmatInsert implements DaoStmtExec_<EmpmatInfo> {
	private DaoStmtExec_<EmpmatInfo> helper;
	
	
	public EmpmatInsert(List<DaoStmtExecOption<EmpmatInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, EmpmatInsertSingle.class, EmpmatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<EmpmatInfo> getResultset() {
		return helper.getResultset();
	}
}
