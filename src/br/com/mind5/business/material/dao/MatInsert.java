package br.com.mind5.business.material.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;

public final class MatInsert implements DaoStmtExec<MatInfo> {
	private DaoStmtExec<MatInfo> helper;
	
	
	public MatInsert(List<DaoStmtExecOption<MatInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatInsertSingle.class, MatInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();
		
	}

	
	
	@Override public List<MatInfo> getResultset() {
		return helper.getResultset();
	}
}
