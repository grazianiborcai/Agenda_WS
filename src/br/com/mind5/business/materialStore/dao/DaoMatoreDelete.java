package br.com.mind5.business.materialStore.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoMatoreDelete implements DaoStmtExec<MatoreInfo> {
	private DaoStmtExec<MatoreInfo> helper;
	
	
	public DaoMatoreDelete(List<DaoStmtExecOption<MatoreInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoMatoreDeleteSingle.class, MatoreInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatoreInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
