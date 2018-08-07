package br.com.gda.business.materialEmployee.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.materialEmployee.info.MatEmpInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class MatEmpDelete implements DaoStmtExec<MatEmpInfo> {
	private DaoStmtExec<MatEmpInfo> helper;
	
	
	public MatEmpDelete(List<DaoStmtExecOption<MatEmpInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatEmpDeleteSingle.class, MatEmpInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<MatEmpInfo> getResultset() {
		return helper.getResultset();
	}
}
