package br.com.gda.business.materialSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.materialSnapshot.info.MatSnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class MatSnapSelect implements DaoStmtExec<MatSnapInfo> {
	private DaoStmtExec<MatSnapInfo> helper;
	
	
	public MatSnapSelect(List<DaoStmtExecOption<MatSnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatSnapSelectSingle.class, MatSnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<MatSnapInfo> getResultset() {
		return helper.getResultset();
	}
}
