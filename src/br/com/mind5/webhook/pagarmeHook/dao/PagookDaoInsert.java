package br.com.mind5.webhook.pagarmeHook.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.dao.DaoStmtExec;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.webhook.pagarmeHook.info.PagookInfo;

public final class PagookDaoInsert implements DaoStmtExec<PagookInfo> {
	private DaoStmtExec<PagookInfo> helper;
	
	
	public PagookDaoInsert(List<DaoStmtExecOption<PagookInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, PagookDaoInsertSingle.class, PagookInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<PagookInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
