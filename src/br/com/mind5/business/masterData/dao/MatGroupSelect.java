package br.com.mind5.business.masterData.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.masterData.info.MatGroupInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatGroupSelect implements DaoStmtExec_<MatGroupInfo> {
	private DaoStmtExec_<MatGroupInfo> helper;
	
	
	public MatGroupSelect(List<DaoStmtExecOption<MatGroupInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatGroupSelectSingle.class, MatGroupInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatGroupInfo> getResultset() {
		return helper.getResultset();
	}
}
