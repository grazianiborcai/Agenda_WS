package br.com.mind5.business.material.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoMatUpdate implements DaoStmtExec<MatInfo> {
	private DaoStmtExec<MatInfo> helper;
	
	
	public DaoMatUpdate(List<DaoStmtExecOption<MatInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoMatUpdateSingle.class, MatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
