package br.com.gda.business.materialStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.materialStore.info.MatStoreInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class MatStoreSelect implements DaoStmtExec<MatStoreInfo> {
	private DaoStmtExec<MatStoreInfo> helper;
	
	
	public MatStoreSelect(List<DaoStmtExecOption<MatStoreInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatStoreSelectSingle.class, MatStoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatStoreInfo> getResultset() {
		return helper.getResultset();
	}
}
