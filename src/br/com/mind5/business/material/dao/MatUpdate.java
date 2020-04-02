package br.com.mind5.business.material.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatUpdate implements DaoStmtExec_<MatInfo> {
	private DaoStmtExec_<MatInfo> helper;
	
	
	public MatUpdate(List<DaoStmtExecOption<MatInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatUpdateSingle.class, MatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatInfo> getResultset() {
		return helper.getResultset();
	}
}
