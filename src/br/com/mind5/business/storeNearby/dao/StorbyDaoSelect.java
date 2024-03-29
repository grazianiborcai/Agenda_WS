package br.com.mind5.business.storeNearby.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeNearby.info.StorbyInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class StorbyDaoSelect implements DaoStmtExec<StorbyInfo> {
	private DaoStmtExec<StorbyInfo> helper;
	
	
	public StorbyDaoSelect(List<DaoStmtExecOption<StorbyInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, StorbyDaoSelectSingle.class, StorbyInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StorbyInfo> getResultset() {
		return helper.getResultset();
	}


	
	@Override public void close() {
		helper.close();		
	}
}
