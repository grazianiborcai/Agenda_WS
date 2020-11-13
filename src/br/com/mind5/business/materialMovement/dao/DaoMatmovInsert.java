package br.com.mind5.business.materialMovement.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialMovement.info.MatmovInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoMatmovInsert implements DaoStmtExec<MatmovInfo> {
	private DaoStmtExec<MatmovInfo> helper;
	
	
	public DaoMatmovInsert(List<DaoStmtExecOption<MatmovInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoMatmovInsertSingle.class, MatmovInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatmovInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
