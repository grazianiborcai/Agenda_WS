package br.com.mind5.business.materialTextDefault.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoMatextaultSelect implements DaoStmtExec<MatextaultInfo> {
	private DaoStmtExec<MatextaultInfo> helper;
	
	
	public DaoMatextaultSelect(List<DaoStmtExecOption<MatextaultInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoMatextaultSelectSingle.class, MatextaultInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatextaultInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
