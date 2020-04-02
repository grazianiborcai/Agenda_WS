package br.com.mind5.business.materialStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class MatoreDelete implements DaoStmtExec_<MatoreInfo> {
	private DaoStmtExec_<MatoreInfo> helper;
	
	
	public MatoreDelete(List<DaoStmtExecOption<MatoreInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, MatoreDeleteSingle.class, MatoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<MatoreInfo> getResultset() {
		return helper.getResultset();
	}
}
