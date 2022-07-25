package br.com.mind5.discount.discountStoreSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.discount.discountStoreSnapshot.info.DisorapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DisorapDaoInsert implements DaoStmtExec<DisorapInfo> {
	private DaoStmtExec<DisorapInfo> helper;
	
	
	public DisorapDaoInsert(List<DaoStmtExecOption<DisorapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DisorapDaoInsertSingle.class, DisorapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<DisorapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
