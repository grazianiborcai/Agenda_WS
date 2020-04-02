package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.FeeCategInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class FeeCategSelect implements DaoStmtExec_<FeeCategInfo> {
	private DaoStmtExec_<FeeCategInfo> helper;
	
	
	public FeeCategSelect(List<DaoStmtExecOption<FeeCategInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, FeeCategSelectSingle.class, FeeCategInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<FeeCategInfo> getResultset() {
		return helper.getResultset();
	}
}
