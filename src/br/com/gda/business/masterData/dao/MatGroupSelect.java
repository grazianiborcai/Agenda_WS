package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class MatGroupSelect implements DaoStmtExec<MatGroupInfo> {
	private DaoStmtExec<MatGroupInfo> helper;
	
	
	public MatGroupSelect(List<DaoStmtExecOption<MatGroupInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatGroupSelectSingle.class, MatGroupInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatGroupInfo> getResultset() {
		return helper.getResultset();
	}
}
