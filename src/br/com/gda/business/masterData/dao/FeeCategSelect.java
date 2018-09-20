package br.com.gda.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.masterData.info.FeeCategInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class FeeCategSelect implements DaoStmtExec<FeeCategInfo> {
	private DaoStmtExec<FeeCategInfo> helper;
	
	
	public FeeCategSelect(List<DaoStmtExecOption<FeeCategInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, FeeCategSelectSingle.class, FeeCategInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FeeCategInfo> getResultset() {
		return helper.getResultset();
	}
}
