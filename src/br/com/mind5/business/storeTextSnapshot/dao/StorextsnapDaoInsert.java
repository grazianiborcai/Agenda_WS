package br.com.mind5.business.storeTextSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class StorextsnapDaoInsert implements DaoStmtExec<StorextsnapInfo> {
	private DaoStmtExec<StorextsnapInfo> helper;
	
	
	public StorextsnapDaoInsert(List<DaoStmtExecOption<StorextsnapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StorextsnapDaoInsertSingle.class, StorextsnapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StorextsnapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
