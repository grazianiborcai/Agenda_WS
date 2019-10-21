package br.com.mind5.business.materialStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class MatoreDelete implements DaoStmtExec<MatoreInfo> {
	private DaoStmtExec<MatoreInfo> helper;
	
	
	public MatoreDelete(List<DaoStmtExecOption<MatoreInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatoreDeleteSingle.class, MatoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<MatoreInfo> getResultset() {
		return helper.getResultset();
	}
}
