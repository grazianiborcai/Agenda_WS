package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.MatCategInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class MatCategSelect implements DaoStmtExec<MatCategInfo> {
	private DaoStmtExec<MatCategInfo> helper;
	
	
	public MatCategSelect(List<DaoStmtExecOption<MatCategInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatCategSelectSingle.class, MatCategInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatCategInfo> getResultset() {
		return helper.getResultset();
	}
}
