package br.com.gda.business.materialStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class MatoreSelect implements DaoStmtExec<MatoreInfo> {
	private DaoStmtExec<MatoreInfo> helper;
	
	
	public MatoreSelect(List<DaoStmtExecOption<MatoreInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatoreSelectSingle.class, MatoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatoreInfo> getResultset() {
		return helper.getResultset();
	}
}
