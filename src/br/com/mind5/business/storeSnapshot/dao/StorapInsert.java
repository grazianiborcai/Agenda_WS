package br.com.mind5.business.storeSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.storeSnapshot.info.StorapInfo;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.obsolete.DaoStmtExecHelper_;
import br.com.mind5.dao.obsolete.DaoStmtExec_;

public final class StorapInsert implements DaoStmtExec_<StorapInfo> {
	private DaoStmtExec_<StorapInfo> helper;
	
	
	public StorapInsert(List<DaoStmtExecOption<StorapInfo>> options) {
		helper = new DaoStmtExecHelper_<>(options, StorapInsertSingle.class, StorapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<StorapInfo> getResultset() {
		return helper.getResultset();
	}
}
