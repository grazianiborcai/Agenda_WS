package br.com.mind5.business.materialTextSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.materialTextSnapshot.info.MatextsnapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class MatextsnapDaoInsert implements DaoStmtExec<MatextsnapInfo> {
	private DaoStmtExec<MatextsnapInfo> helper;
	
	
	public MatextsnapDaoInsert(List<DaoStmtExecOption<MatextsnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, MatextsnapDaoInsertSingle.class, MatextsnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<MatextsnapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
