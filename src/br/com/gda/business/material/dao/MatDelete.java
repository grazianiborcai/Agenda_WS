package br.com.gda.business.material.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.material.info.MatInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class MatDelete implements DaoStmtExec<MatInfo> {
	private DaoStmtExec<MatInfo> helper;
	
	
	public MatDelete(List<DaoStmtExecOption<MatInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatDeleteSingle.class, MatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<MatInfo> getResultset() {
		return helper.getResultset();
	}
}
