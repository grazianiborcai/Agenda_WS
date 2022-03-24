package br.com.mind5.business.orderItemSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class OrdemrapDaoInsert implements DaoStmtExec<OrdemrapInfo> {
	private DaoStmtExec<OrdemrapInfo> helper;
	
	
	public OrdemrapDaoInsert(List<DaoStmtExecOption<OrdemrapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, OrdemrapDaoInsertSingle.class, OrdemrapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OrdemrapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
