package br.com.mind5.business.ownerSnapshot.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.mind5.business.ownerSnapshot.info.OwnerapInfo;
import br.com.mind5.dao.DaoStmtExecHelper;
import br.com.mind5.dao.DaoStmtExecOption;
import br.com.mind5.dao.DaoStmtExec;

public final class DaoOwnerapInsert implements DaoStmtExec<OwnerapInfo> {
	private DaoStmtExec<OwnerapInfo> helper;
	
	
	public DaoOwnerapInsert(List<DaoStmtExecOption<OwnerapInfo>> options) {
		helper = new DaoStmtExecHelper<>(options, DaoOwnerapInsertSingle.class, OwnerapInfo.class);
	}
	
	
	
	@Override public void executeStmt() throws SQLException {
		helper.executeStmt();		
	}

	
	
	@Override public List<OwnerapInfo> getResultset() {
		return helper.getResultset();
	}
	
	
	
	@Override public void close() {
		helper.close();		
	}
}
