package br.com.gda.business.materialTextSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class MatextsnapSelect implements DaoStmtExec<MatextsnapInfo> {
	private DaoStmtExec<MatextsnapInfo> helper;
	
	
	public MatextsnapSelect(List<DaoStmtExecOption<MatextsnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatextsnapSelectSingle.class, MatextsnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatextsnapInfo> getResultset() {
		return helper.getResultset();
	}
}
