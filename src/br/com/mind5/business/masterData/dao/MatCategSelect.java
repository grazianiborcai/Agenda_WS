package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatCategSelect implements DaoStmtExec_<MatCategInfo> {
	private DaoStmtExec_<MatCategInfo> helper;
	
	
	public MatCategSelect(List<DaoStmtExecOption<MatCategInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatCategSelectSingle.class, MatCategInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatCategInfo> getResultset() {
		return helper.getResultset();
	}
}
