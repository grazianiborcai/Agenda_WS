package br.com.mind5.business.materialTextDefault.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatextaultSelect implements DaoStmtExec_<MatextaultInfo> {
	private DaoStmtExec_<MatextaultInfo> helper;
	
	
	public MatextaultSelect(List<DaoStmtExecOption<MatextaultInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatextaultSelectSingle.class, MatextaultInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatextaultInfo> getResultset() {
		return helper.getResultset();
	}
}
