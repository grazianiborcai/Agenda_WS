package br.com.gda.business.materialMovement.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.gda.business.materialMovement.info.MatmovInfo;
import br.com.gda.dao.DaoStmtExec;
import br.com.gda.dao.DaoStmtExecHelper;
import br.com.gda.dao.DaoStmtExecOption;

public final class MatmovInsert implements DaoStmtExec<MatmovInfo> {
	private DaoStmtExec<MatmovInfo> helper;
	
	
	public MatmovInsert(List<DaoStmtExecOption<MatmovInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatmovInsertSingle.class, MatmovInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatmovInfo> getResultset() {
		return helper.getResultset();
	}
}
